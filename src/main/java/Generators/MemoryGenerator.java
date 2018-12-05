package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MemoryGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;
    private String[] memoryType = new String[]{"LAPTOP","DESKTOP","DESKTOP"};

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/memoryGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 75000; i++) {
            printWriter.println("INSERT INTO MEMORY(MODEL_ID,MEMORY_SIZE,CLOCK_RATE,TYPE) " +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().numberBetween(1, 84000) + "," +
                    "" + faker.number().numberBetween(300, 8000) + "," +
                    "'" + memoryType[i%3]+"');");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
