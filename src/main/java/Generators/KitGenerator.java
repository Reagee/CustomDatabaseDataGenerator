package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class KitGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/kitGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 2500000; i++) {
            String name = faker.pokemon().name();
            if (name.equals("Farfetch'd"))
                name = "Farfetch d";
            printWriter.println("INSERT INTO KIT(" +
                    "NAME,CPU_ID,GPU_ID,HARD_DISC_ID,MEMORY_ID,COVER_ID,DVD_DRIVE_ID," +
                    "POWER_SUPPLY_ID,MOTHERBOARD_ID,COOLING_ID,NETWORK_CARD_ID,KIT_TYPE,PRICE) " +
                    "VALUES('" + faker.app().name() + "'," +
                    "" + faker.number().numberBetween(1, 100000) + "," +
                    "" + faker.number().numberBetween(1, 100000) + "," +
                    "" + faker.number().numberBetween(1, 75000) + "," +
                    "" + faker.number().numberBetween(1, 75000) + "," +
                    "" + faker.number().numberBetween(1, 50000) + "," +
                    "" + faker.number().numberBetween(1, 75000) + "," +
                    "" + faker.number().numberBetween(1, 75000) + "," +
                    "" + faker.number().numberBetween(1, 100000) + "," +
                    "" + faker.number().numberBetween(1, 75000) + "," +
                    "" + faker.number().numberBetween(1, 75000) + "," +
                    "'" + name + "'," +
                    "" + faker.number().randomDouble(2, 1299, 18999) + ");");
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }
}
