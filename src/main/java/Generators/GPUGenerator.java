package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GPUGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/gpuGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100000; i++) {
            printWriter.println("INSERT INTO GPU(MODEL_ID,TYPE_ID,SERIES,CLOCK_SPEED,MEMORY,RAMDAC_SPEEC,NUM_OF_INPUTS,BUS_WIDTH,PRICE) " +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().numberBetween(1, 3) + "," +
                    "'" + faker.lorem().word() + "'," +
                    "'" + faker.number().numberBetween(1500, 7500) + "'," +
                    "" + faker.number().numberBetween(256,17000) + "," +
                    "" + faker.number().numberBetween(1000,8000) + "," +
                    "" + faker.number().numberBetween(1,32) + "," +
                    "" + faker.number().numberBetween(1000,6000) + "," +
                    "" + faker.number().randomDouble(2,499,5999)+");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
