package Generators;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class OrdersGenerator {
    private Faker faker = new Faker();
    private PrintWriter printWriter;
    private GregorianCalendar gc = new GregorianCalendar();

    public void generate() {
        try {
            printWriter = new PrintWriter(new File("Generations_SQL/ordersGeneration.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10000; i++) {

            int year = randBetween(2000, 2018);
            gc.set(YEAR, year);
            int dayOfYear = randBetween(1, gc.getActualMaximum(DAY_OF_YEAR));
            gc.set(DAY_OF_YEAR, dayOfYear);

            int productOrKit = (int) Math.random() % 6;

            int categoryNumber = faker.number().numberBetween(1, 14);
            int productId = 0;
            switch (categoryNumber) {
                case 1:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 2:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 3:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 4:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 5:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 6:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 7:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 8:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 9:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 10:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 11:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 12:
                    productId = faker.number().numberBetween(0, 0);
                    break;
                case 13:
                    productId = faker.number().numberBetween(0, 0);
                    break;
            }
            if (productOrKit < 4) {
                printWriter.println("INSERT INTO ORDERS(CUSTOMER_ID,PRODUCT_CATEGORY_ID,PRODUCT_ID,ORDER_DATE,PRICE) " +
                        "VALUES(" + faker.number().numberBetween(1, 1000000) + "," +
                        "" + categoryNumber + "," +
                        "" + productId + "," +
                        "'" + (gc.get(YEAR)) + "-" + (gc.get(MONTH) + 1) + "-" + (gc.get(DAY_OF_MONTH)) + "'," +
                        "" + faker.number().randomDouble(2, 1229, 32000) + ");");
            } else {
                printWriter.println("INSERT INTO ORDERS(CUSTOMER_ID,PRODUCT_CATEGORY_ID,PRODUCT_ID,KIT_ID,ORDER_DATE,PRICE) " +
                        "VALUES(" + faker.number().numberBetween(1, 1000000) + "," +
                        "" + categoryNumber + "," +
                        "" + productId + "," +
                        "" + faker.number().numberBetween(1, 2500000) + "," +
                        "'" + (gc.get(YEAR)) + "-" + (gc.get(MONTH) + 1) + "-" + (gc.get(DAY_OF_MONTH)) + "'," +
                        "" + faker.number().randomDouble(2, 2499, 42000) + ");");
            }
        }
        printWriter.println("COMMIT;");
        printWriter.close();
    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}
