package console;

import dailyHistory.DailyHistory;
import database.Database;
import product.Product;
import restaurant.Restaurant;
import service.External;
import service.Service;

import java.io.IOException;
import java.util.*;


public class Main {
       public static void main(String[] args) {
        External firstImport = new External();
        Scanner s = new Scanner(System.in);
        Database db = new Database();
        Restaurant hall = new Restaurant();
        DailyHistory dh = new DailyHistory();
        Service serviceClass = new Service();

           try {
               firstImport.importDatabase("src/database/database.csv", db);
           } catch (IOException e) {
               e.printStackTrace();
           }

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
                    try {
                        serviceClass.serviceMode(db, dh);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        serviceClass.serveMode(hall, db, dh);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

            }
        }
    }
}
