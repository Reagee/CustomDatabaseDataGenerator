package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HardDiscGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/hardDiscGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 75000; i++) {
            printWriter.println("INSERT INTO HARD_DISC(MODEL_ID,TYPE_ID,TECHNOLOGY,CAPACITANCE,WRITE_SPEED,READ_SPEED,HARD_DISC_SIZE,PRICE) " +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().numberBetween(1, 3) + "," +
                    "'" + faker.lorem().word() + "" + faker.name().name() + "'," +
                    "" + faker.number().numberBetween(128, 12288) + "," +
                    "" + faker.number().numberBetween(100, 1800) + "," +
                    "" + faker.number().numberBetween(50, 9000) + "," +
                    "'" + faker.number().numberBetween(5, 30) + "x" + faker.number().numberBetween(5, 30) + "'," +
                    "" + faker.number().randomDouble(2, 59, 2599) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
