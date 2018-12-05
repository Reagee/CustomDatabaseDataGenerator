package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CPUGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/cpuGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100000; i++) {
            printWriter.println("INSERT INTO CPU(MODEL_ID,TYPE_ID,SERIES,SOCKET_TYPE_ID,CORE,FREQUENCY,CACHE,PRICE) " +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().numberBetween(1, 3) + "," +
                    "'" + faker.lorem().word() + "'," +
                    "" + faker.number().numberBetween(1, 50000) + "," +
                    "'" + faker.lorem().word() + "'," +
                    "" + faker.number().numberBetween(1000,7000) + "," +
                    "" + faker.number().numberBetween(2,32) + "," +
                    "" + faker.number().randomDouble(2,199,1999)+");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
