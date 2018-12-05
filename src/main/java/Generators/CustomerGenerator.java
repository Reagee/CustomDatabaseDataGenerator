package Generators;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class CustomerGenerator {
    private Faker faker = new Faker();
    private Fairy fairy = Fairy.create();
    private PrintWriter printWriter;
    private GregorianCalendar gc = new GregorianCalendar();

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/customerGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 999000; i++) {
            Person person = fairy.person();
            int year = randBetween(1930, 2000);
            gc.set(YEAR, year);
            int dayOfYear = randBetween(1, gc.getActualMaximum(DAY_OF_YEAR));
            gc.set(DAY_OF_YEAR, dayOfYear);
            printWriter.println("INSERT INTO CUSTOMER(NAME,SURNAME,DATE_OF_BIRTH,ADDRESS,COUNTRY) " +
                    "VALUES('" + person.getFirstName() + "'," +
                    "'" + person.getLastName() + "'," +
                    "'" + (gc.get(YEAR)) + "-" + (gc.get(MONTH) + 1) + "-" + (gc.get(DAY_OF_MONTH)) + "'," +
                    "'" +person.getAddress().getAddressLine1() + " " + person.getAddress().getAddressLine2() + "'," +
                    "'" + faker.address().country().replaceAll("'"," ").replaceAll("&"," ") + "');");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}
