package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DOrdersGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/dOrdersGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100000; i++) {
            printWriter.println("INSERT INTO ORDERS(TIME_ID,CLIENT_ID,COUNTRY_ID,PRODUCER_AGE_ID,PRODUCER_SIZE_ID,PRODUCT_ID,BRAND_ID,CATEGORY_ID) VALUES(" +
                    "" + faker.number().numberBetween(1, 930001) + "," +
                    "" + faker.number().numberBetween(1, 1000002) + "," +
                    "" + faker.number().numberBetween(1, 240) + "," +
                    "" + faker.number().numberBetween(1, 5000) + "," +
                    "" + faker.number().numberBetween(1, 5000) + "," +
                    "" + faker.number().numberBetween(1, 9880155) + "," +
                    "" + faker.number().numberBetween(1, 5000) + "," +
                    "" + faker.number().numberBetween(1, 14) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
