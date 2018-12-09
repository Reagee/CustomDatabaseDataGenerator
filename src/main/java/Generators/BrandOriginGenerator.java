package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BrandOriginGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/brandOriginGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 5001; i++) {
            printWriter.println("UPDATE BRAND SET ORIGIN='" + faker.address().country().replaceAll("'","").replaceAll("&","and")+ "' WHERE ID=" + i + ";");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
