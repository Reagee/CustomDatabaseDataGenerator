package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CollingGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/coolingGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 75000; i++) {
            printWriter.println("INSERT INTO COOLING(NAME,TYPE,POWER,PRICE)" +
                    "VALUES('" + faker.app().name() + "'," +
                    "'" + faker.pokemon().name() + " " + faker.name().username()+ "'," +
                    "" + faker.number().randomDouble(2, 10, 200) + "," +
                    "" + faker.number().randomDouble(2, 39, 899) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
