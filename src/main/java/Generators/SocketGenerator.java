package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SocketGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;
    public void generate(){
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/socketGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<50000;i++){
            printWriter.println("INSERT INTO SOCKET(NAME,TYPE) VALUES('"+faker.internet().domainWord()+"','"+faker.number().numberBetween(100,3000)+"');");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
