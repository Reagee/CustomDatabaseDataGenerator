package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MotherboardGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/motherboardGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100000; i++) {
            printWriter.println("INSERT INTO MOTHERBOARD(MODEL_ID,CHIPSET,SOCKET_ID,DIMM_SLOTS,INPUTS,VOLTAGE,COOLING_ID,PRICE)" +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "'" + faker.pokemon().name() + "'," +
                    "" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().numberBetween(1, 5000) + "," +
                    "'" + faker.hacker().verb() + "'," +
                    "" + faker.number().randomDouble(2, 12, 230) + "," +
                    "" + faker.number().numberBetween(1, 29131) + "," +
                    "" + faker.number().randomDouble(2, 299, 1899) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
