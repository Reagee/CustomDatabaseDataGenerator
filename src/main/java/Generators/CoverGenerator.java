package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CoverGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/coverGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 50000; i++) {
            printWriter.println("INSERT INTO COVER(MODEL_ID,COLOR,COVER_SIZE,PRICE) " +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "'" + faker.color().name() + "'," +
                    "'" + faker.number().numberBetween(20, 200) + "x"+faker.number().numberBetween(20,200)+"'," +
                    "" + faker.number().randomDouble(2,39,599)+");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
