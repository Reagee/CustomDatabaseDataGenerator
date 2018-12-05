package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LaptopKitGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/laptopKit2Generation.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000000; i++) {
            printWriter.println("INSERT INTO LAPTOP_KIT(MODEL_ID,KIT_ID,SCREEN_SIZE,SCREEN_TYPE_ID,PRICE) " +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().numberBetween(1, 2500000) + "," +
                    "" + faker.number().randomDouble(1, 10, 26) + "," +
                    "" + faker.number().numberBetween(1, 4) + "," +
                    "" + faker.number().randomDouble(2, 1199, 13999) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
