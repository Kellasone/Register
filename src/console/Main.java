package console;

import dailyHistory.DailyHistory;
import database.Database;
import product.Product;
import restaurant.Restaurant;
import service.External;
import service.Service;

import java.io.*;
import java.util.*;


public class Main {
    protected static Scanner s = new Scanner(System.in);
    protected static Database db = new Database();
    protected static Restaurant hall = new Restaurant();
    protected static DailyHistory dh = new DailyHistory();
    protected static Product newProduct;
    private static Service serviceClass = new Service();
    public static void main(String[] args) throws IOException {

        External firstImport;
        firstImport = new External();
        firstImport.importDatabase("src/database/database.csv");


        int typeOfModule = 1;

        while(typeOfModule!=0) {
            System.out.println("Select desired Module");
            System.out.println("0. Exit");
            System.out.println("1. Service");
            System.out.println("2. Serve");

            typeOfModule = s.nextInt();

            switch (typeOfModule) {
                case 0:
                    System.exit(0);
                case 1:
                    serviceClass.serviceMode();
                    break;
                case 2:
                    serviceClass.serveMode();
                    break;

        }
    }
    }
}
