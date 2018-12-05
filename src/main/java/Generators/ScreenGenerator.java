package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ScreenGenerator {
    private Faker faker = new Faker();
    private  PrintWriter printWriter;
    public void generate(){
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/screenGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<100000;i++){
            printWriter.println("INSERT INTO SCREEN(MODEL_ID,SCREEN_SIZE,TECHNOLOGY,SCREEN_TYPE_ID,CONTRAST,REACTION_TIME,INPUTS,VOLTAGE,SCREEN_POWER,PRICE) " +
                    "VALUES("+faker.number().numberBetween(1,50000)+"," +
                    ""+faker.number().randomDouble(1,12,70)+"," +
                    "'"+faker.app().name()+"',"+
                    ""+faker.number().numberBetween(1,4)+"," +
                    "'"+faker.number().numberBetween(1000,100000000)+":1'," +
                    ""+faker.number().numberBetween(1,100)+"," +
                    "'"+faker.lorem().words(10)+"'," +
                    ""+faker.number().randomDouble(2,10,230)+"," +
                    ""+faker.number().randomDouble(2,10,800)+"," +
                    ""+faker.number().randomDouble(2,49,2000)+");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
