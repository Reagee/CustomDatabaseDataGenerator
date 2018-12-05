package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BrandGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/brandGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<5000;i++){
            printWriter.println("INSERT INTO BRAND(NAME) VALUES('"+faker.app().name()+"');");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
