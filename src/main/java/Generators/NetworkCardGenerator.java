package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NetworkCardGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/networkCardGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 75000; i++) {
            printWriter.println("INSERT INTO NETWORK_CARD(MODEL_ID,SPEED,CERTIFICATES,PRICE)" +
                    "VALUES(" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().numberBetween(100,2400) + "," +
                    "'" + faker.internet().domainWord() + "'," +
                    "" + faker.number().randomDouble(2, 49, 2200) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
