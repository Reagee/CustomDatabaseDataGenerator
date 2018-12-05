package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DesktopKitGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/desktopKitGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1500000; i++) {
            printWriter.println("INSERT INTO DESKTOP_KIT(KIT_ID,SCREEN_ID,PRICE) " +
                    "VALUES(" + faker.number().numberBetween(1, 2500000) + "," +
                    "" + faker.number().numberBetween(1, 80001) + "," +
                    "" + faker.number().randomDouble(2, 2599, 24999) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
