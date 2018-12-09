package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class ProducerDetailsGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;
    private GregorianCalendar gc = new GregorianCalendar();

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/producerDetailsGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 5001; i++) {
            int year = randBetween(1930, 2018);
            gc.set(YEAR, year);
            int dayOfYear = randBetween(1, gc.getActualMaximum(DAY_OF_YEAR));
            gc.set(DAY_OF_YEAR, dayOfYear);
            printWriter.println("INSERT INTO PRODUCER_DETAILS(PRODUCER_START_ACTIV_DATE,PRODUCER_PEOPLE_EMPLOYEED) VALUES(" +
                    "'" + (gc.get(YEAR)) + "-" + (gc.get(MONTH) + 1) + "-" + (gc.get(DAY_OF_MONTH)) + "'," +
                    "" + faker.number().numberBetween(100, 300000) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}
