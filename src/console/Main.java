package console;

import dailyHistory.SqlDailyHistory;
import database.SqlDatabase;
import restaurant.SqlRestaurant;
import service.Service;


import java.io.IOException;
import java.util.*;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner s = new Scanner(System.in);

        SqlDatabase db = new SqlDatabase();
        SqlRestaurant hall = new SqlRestaurant();
        SqlDailyHistory dh = new SqlDailyHistory();
        Service serviceClass = new Service();

        int typeOfModule = 1;

        while (typeOfModule != 0) {
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
