package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class returnsGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;
    private GregorianCalendar gc = new GregorianCalendar();

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/returnsGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= 20000; i++) {
            int year = randBetween(2000, 2018);
            gc.set(YEAR, year);
            int dayOfYear = randBetween(1, gc.getActualMaximum(DAY_OF_YEAR));
            gc.set(DAY_OF_YEAR, dayOfYear);
            printWriter.println("INSERT INTO RETURNS(TIME_ID,ORDER_ID) VALUES(" +
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
