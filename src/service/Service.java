package service;

import dailyHistory.SqlDailyHistory;
import database.SqlDatabase;
import product.*;
import restaurant.SqlRestaurant;

import java.io.*;
import java.sql.*;
import java.util.Scanner;


public class Service {
    private static Service service;
    Log log = new Log();


    public static Service Service() throws IOException {
        if (service == null) {
            service = new Service();
            return service;
        }
        return service;
    }

    public void serviceMode(SqlDatabase db, SqlDailyHistory dh) throws IOException, SQLException {
        String threadName = Thread.currentThread().getName();
        Scanner s = new Scanner(System.in);
        int typeOfService = 1;
        while (typeOfService != 0) {
            System.out.println("Select desired service:");
            System.out.println("0. Back");
            System.out.println("1. Add product in DB");
            System.out.println("2. Remove product from DB");
            System.out.println("3. Change item price");
            System.out.println("4. List database");
            System.out.println("5. See Daily History");
            System.out.println("6. Close the register");


            typeOfService = s.nextInt();

            switch (typeOfService) {
                case 0:
                    break;
                case 1:
                    System.out.println("\t product type: ");
                    System.out.println("\t 1.Alcoholic Drink ");
                    System.out.println("\t 2.Non-Alcoholic Drink ");
                    System.out.println("\t 3.Food ");
                    System.out.println("\t 4.Cleaning product ");
                    int typeOfProduct = s.nextInt();
                    System.out.println("\t Name:");
                    String nameOfProduct = s.next();
                    System.out.println("\t Price:");
                    double priceOfProduct = s.nextDouble();


                    if (typeOfProduct == 1) {
                        System.out.println("\t Alcohol percentage: ");
                        Product p = new Alcoholic(nameOfProduct, priceOfProduct, s.nextInt());
                        if (db.contains(p)) {
                            System.out.println("Product already in database. Aborting...");
                        } else
                            db.addProduct(p);

                    }
                    if (typeOfProduct == 2) {
                        System.out.println("\t Beverage type: ");
                        Product p = new NonAlcoholic(nameOfProduct, priceOfProduct, s.next());
                        if (db.contains(p)) {
                            System.out.println("Product already in database. Aborting...");
                        } else {
                            db.addProduct(p);
                        }
                    }
                    if (typeOfProduct == 3) {
                        Product p = new Food(nameOfProduct, priceOfProduct);
                        if (db.contains(p)) {
                            System.out.println("Product already in database. Aborting...");
                        } else {
                            db.addProduct(p);
                        }
                    }
                    if (typeOfProduct == 4) {
                        System.out.println("\t Cleaning product type: ");
                        Product p = new CleaningProducts(nameOfProduct, priceOfProduct, s.next());
                        if (db.contains(p)) {
                            System.out.println("product already in database. Aborting...");
                        } else {
                            db.addProduct(p);
                        }
                    }

                    log.addToLog("src/logs/logfile.csv", "ADD_PRODUCT_TO_DB", threadName);
                    break;
                case 2:
                    System.out.println("Name of the product you want to delete: ");
                    String itemToDelete = s.next();
                    if (db.contains(itemToDelete)) {
                        db.removeProduct(itemToDelete);
                    } else
                        System.out.println("product not in the DataBase!");
                    log.addToLog("src/logs/logfile.csv", "REMOVE_PRODUCT_FROM_DB", threadName);
                    break;
                case 3:
                    System.out.println("Enter Product name: ");
                    String productName = s.next();
                    System.out.println("Old price was " + db.getProduct(productName).getPrice() + ". Enter new price: ");
                    double newPrice = s.nextDouble();
                    db.changePrice(productName, newPrice);
                    break;
                case 4:
                    System.out.println(db.getProductList());
                    log.addToLog("src/logs/logfile.csv", "LIST_PRODUCTLIST", threadName);
                    break;
                case 5:
                    log.addToLog("src/logs/logfile.csv", "SEE_DAILY_HISTORY", threadName);
                    System.out.println(dh);
                    break;
                case 6:
                    System.out.println(dh);
                    dh.delete();
                    log.addToLog("src/logs/logfile.csv", "CLOSE_THE_REGISTER", threadName);
                    break;
            }
        }
    }

    public void serveMode(SqlRestaurant hall, SqlDatabase db, SqlDailyHistory dh) throws IOException, SQLException {
        String threadName = Thread.currentThread().getName();
        Scanner s = new Scanner(System.in);
        int typeOfServe = 1;
        while (typeOfServe != 0) {
            System.out.println("Select desired serve option:");
            System.out.println("0. Back");
            System.out.println("1. Add client");
            System.out.println("2. See present clients");
            System.out.println("3. Access a client");

            typeOfServe = s.nextInt();
            switch (typeOfServe) {
                case 0:
                    break;
                case 1:
                    hall.addClient();
                    log.addToLog("src/logs/logfile.csv", "ADD_CLIENT", threadName);
                    break;

                case 2:
                    hall.listClients();
                    log.addToLog("src/logs/logfile.csv", "LIST_CLIENTS", threadName);
                    break;
                case 3:
                    System.out.println("Which client do you want to acces?");
                    int actualClient = s.nextInt();
                    log.addToLog("src/logs/logfile.csv", "ACCES CLIENT " + actualClient, threadName);
                    if (hall.contains(actualClient)) {
                        int options = 1;
                        while (options != 0) {
                            System.out.println("Select an action: ");
                            System.out.println("0. Back");
                            System.out.println("1. Add product");
                            System.out.println("2. See client products");
                            System.out.println("3. Remove product");
                            System.out.println("4. Cashout the client");
                            options = s.nextInt();
                            switch (options) {
                                case 0:
                                    break;
                                case 1:
                                    System.out.println("Enter the name of the product");
                                    String productName;
                                    productName = s.next();
                                    System.out.println("Enter the number of products");
                                    int numberOfProducts = s.nextInt();
                                    hall.addProductsOnClient(actualClient, productName, numberOfProducts);
                                    log.addToLog("src/logs/logfile.csv", "ADD_PRODUCT_TO_CLIENT", threadName);
                                    break;
                                case 2:
                                    hall.showClientProducts(actualClient);
                                    log.addToLog("src/logs/logfile.csv", "SEE_CLIENT_PRODUCTS", threadName);
                                    break;

                                case 3:
                                    System.out.println("Enter the name of the product you want to delete:");
                                    String productToDelete = s.next();
                                    System.out.println("Enter the quantity of the product:");
                                    int numberOfProductsToDelete = s.nextInt();
                                    hall.removeClientProducts(actualClient, productToDelete, numberOfProductsToDelete);
                                    log.addToLog("src/logs/logfile.csv", "REMOVE_CLIENT_PRODUCT", threadName);
                                    break;
                                case 4:

                                    Connection sqlDatabaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
                                    String command = "Select * from client_" + actualClient;
                                    Statement statement = sqlDatabaseConnection.createStatement();
                                    ResultSet resultSet = statement.executeQuery(command);

                                    while (resultSet.next()) {
                                        dh.addEntry(actualClient, resultSet.getString(1), resultSet.getInt(2));
                                    }
                                    hall.removeClient(actualClient);
                                    log.addToLog("src/logs/logfile.csv", "CLIENT_CASHOUT", threadName);
                                    break;

                            }

                        }
                    } else System.out.println("Client left or not entered yet!");

                    break;
            }
        }
    }
}
