package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ModelGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/modelGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<50000;i++){
            printWriter.println("INSERT INTO MODEL(BRAND_ID,NAME) VALUES("+faker.number().numberBetween(1,5000)+",'"+faker.beer().name()+"');");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
