package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PowerSupplyGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/powerSupplyGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 75000; i++) {
            printWriter.println("INSERT INTO POWER_SUPPLY(MODEL_ID,POWER,VOLTAGE,PLUG_TYPE,SECURITY_TYPES,PRICE)" +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().randomDouble(2, 100, 1800) + "," +
                    "" + faker.number().randomDouble(2, 10, 230) + "," +
                    "'" + faker.app().name() + "'," +
                    "'" + faker.lorem().words(25) + "'," +
                    "" + faker.number().randomDouble(2, 49, 1800) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}

