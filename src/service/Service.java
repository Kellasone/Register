package service;

import product.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Service extends console.Main{
    private static Service service;
    External externalDatabase;
    Log log = new Log();


    public static Service Service() throws IOException, FileNotFoundException {
        if (service == null) {
            service = new Service();
            return service;
        }
        return service;
    }
        public void serviceMode() throws IOException, FileNotFoundException
        {
            int typeOfService=1;
            while (typeOfService != 0) {
                System.out.println("Select desired service:");
                System.out.println("0. Back");
                System.out.println("1. Add product in DB");
                System.out.println("2. Remove product from DB");
                System.out.println("3. List database");
                System.out.println("4. See Daily History");
                System.out.println("5. Close the register");
                System.out.println("6. Import DB");
                System.out.println("7. Export DB");


                typeOfService = this.s.nextInt();

                switch (typeOfService) {
                    case 0:
                        break;
                    case 1:


                        System.out.println("\t product type: ");
                        System.out.println("\t 1.Alcoholic Drink ");
                        System.out.println("\t 2.Non-Alcoholic Drink ");
                        System.out.println("\t 3.Food ");
                        System.out.println("\t 4.Cleaning product ");
                        int typeOfProduct = this.s.nextInt();
                        System.out.println("\t Name:");
                        String nameOfProduct = this.s.next();
                        System.out.println("\t Price:");
                        double priceOfProduct = this.s.nextDouble();


                        if (typeOfProduct == 1) {
                            System.out.println("\t Alcohol percentage: ");
                            Product p = new Alcoholic(nameOfProduct, priceOfProduct, s.nextInt());
                            if (this.db.contains(p)) {
                                System.out.println("product already in database. Aborting...");
                            } else
                                this.db.addProduct(p);

                        }
                        if (typeOfProduct == 2) {
                            System.out.println("\t Beverage type: ");
                            Product p = new NonAlcoholic(nameOfProduct, priceOfProduct, this.s.next());
                            if (this.db.contains(p)) {
                                System.out.println("product already in database. Aborting...");
                            } else {
                                this.db.addProduct(p);
                            }
                        }
                        if (typeOfProduct == 3) {
                            Product p = new Food(nameOfProduct, priceOfProduct);
                            if (this.db.contains(p)) {
                                System.out.println("product already in database. Aborting...");
                            } else {
                                this.db.addProduct(p);
                            }
                        }
                        if (typeOfProduct == 4) {
                            System.out.println("\t Cleaning product type: ");
                            Product p = new CleaningProducts(nameOfProduct, priceOfProduct, this.s.next());
                            if (this.db.contains(p)) {
                                System.out.println("product already in database. Aborting...");
                            } else {
                                this.db.addProduct(p);
                            }
                        }

                        log.addToLog("src/logs/logfile.csv","ADD_PRODUCT_TO_DB");
                        break;
                    case 2:
                        System.out.println("Name of the product you want to delete: ");
                        String itemToDelete = this.s.next();
                        if (this.db.contains(itemToDelete)) {
                            this.db.removeProduct(itemToDelete);
                        } else
                            System.out.println("product not in the DataBase!");
                        log.addToLog("src/logs/logfile.csv","REMOVE_PRODUCT_FROM_DB");
                        break;
                    case 3:
                        System.out.println(this.db.getProductList());
                        log.addToLog("src/logs/logfile.csv","LIST_PRODUCTLIST");
                        break;
                    case 4:
                        log.addToLog("src/logs/logfile.csv","SEE_DAILY_HISTORY");
                        System.out.println(this.dh);
                        break;
                    case 5:
                        System.out.println(this.dh);
                        this.dh.delete();
                        log.addToLog("src/logs/logfile.csv","CLOSE_THE_REGISTER");
                        break;
                    case 6:
                        externalDatabase = new External();
                        externalDatabase.importDatabase("src/database/database.csv");
                        log.addToLog("src/logs/logfile.csv","IMPORT_DATABASE");
                        break;
                    case 7:
                        externalDatabase = new External();
                        externalDatabase.exportDatabase("src/database/database.csv");
                        log.addToLog("src/logs/logfile.csv","EXPORT_DATABASE");
                        break;


                }

            }
        }

        public void serveMode() throws IOException
        {
            int typeOfServe=1;
            while (typeOfServe!= 0) {
                System.out.println("Select desired serve option:");
                System.out.println("0. Back");
                System.out.println("1. Add client");
                System.out.println("2. See present clients");
                System.out.println("3. Access a client");

                typeOfServe = s.nextInt();
                switch(typeOfServe){
                    case 0:
                        break;
                    case 1:
                        hall.addClient();
                        log.addToLog("src/logs/logfile.csv","ADD_CLIENT");
                        break;

                    case 2:
                        System.out.println(hall.getClientList());
                        log.addToLog("src/logs/logfile.csv","LIST_CLIENTS");
                        break;
                    case 3:
                        System.out.println("Which client do you want to acces?");
                        int actualClient = s.nextInt();
                        log.addToLog("src/logs/logfile.csv","ACCES CLIENT "+actualClient);
                        if(hall.contains(actualClient))
                        {
                            int options=1;
                            while (options!=0)
                            {
                                System.out.println("Select an action: ");
                                System.out.println("0. Back");
                                System.out.println("1. Add product");
                                System.out.println("2. See client products");
                                System.out.println("3. Remove product");
                                System.out.println("4. Cashout the client");
                                options=s.nextInt();
                                switch (options){
                                    case 0:
                                        break;
                                    case 1:
                                        System.out.println("Enter the name of the product");
                                        String productName;
                                        productName = s.next();
                                        Product productToAdd = db.getProduct(productName);
                                        System.out.println("Enter the number of products");
                                        int numberOfProducts = s.nextInt();
                                        hall.getClient(actualClient).addProduct(productToAdd, numberOfProducts);
                                        log.addToLog("src/logs/logfile.csv","ADD_PRODUCT_TO_CLIENT");
                                        break;
                                    case 2:
                                        System.out.println(hall.getClient(actualClient).getClientProducts());
                                        log.addToLog("src/logs/logfile.csv","SEE_CLIENT_PRODUCTS");
                                        break;

                                    case 3:
                                        System.out.println("Enter the name of the product you want to delete:");
                                        String productToDelete = s.next();
                                        System.out.println("Enter the quantity of the product:");
                                        int numberOfProductsToDelete = s.nextInt();
                                        Product product = db.getProduct(productToDelete);
                                        HashMap<Integer, Product> productHashMap = new HashMap<>();
                                        productHashMap.put(numberOfProductsToDelete,product);
                                        hall.getClient(actualClient).removeProduct(productHashMap);
                                        log.addToLog("src/logs/logfile.csv","REMOVE_CLIENT_PRODUCT");
                                        break;
                                    case 4:
                                        ArrayList<HashMap<Integer, Product> > clientProducts = hall.getClient(actualClient).getClientProducts();
                                        HashMap<Integer, ArrayList<HashMap<Integer, Product> >> entryForDH = new HashMap<>();
                                        entryForDH.put(hall.getClient(actualClient).getClientNumber(), hall.getClient(actualClient).getClientProducts());
                                        dh.addEntry(entryForDH);
                                        hall.removeClient(actualClient);
                                        log.addToLog("src/logs/logfile.csv","CLIENT_CASHOUT");
                                        break;

                                }

                            }
                        }
                        else System.out.println("Client left or not entered yet!");

                        break;

                }

            }
        }
    }
