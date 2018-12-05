package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DvdDriveGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/dvdDriveGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 75000; i++) {
            printWriter.println("INSERT INTO DVD_DRIVE(MODEL_ID,SPEED,POWER_CONSUMPTION,PRICE) " +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().numberBetween(50, 1000) + "," +
                    "" + faker.number().numberBetween(20, 350) + "," +
                    "" + faker.number().randomDouble(2, 39, 399) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
