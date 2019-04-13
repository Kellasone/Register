package Main;


import Database.Database;
import Product.CleaningProducts;
import Product.Product;
import Product.Food;
import Product.Alcoholic;
import Product.NonAlcoholic;

import java.util.Scanner;


public class Main {
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Database db = new Database();
        int typeOfService = 1;

        while(typeOfService!=0) {
            System.out.println("Select desired service:");
            System.out.println("0. Exit");
            System.out.println("1. Add Product in DB");
            System.out.println("2. Remove Product from DB");
            System.out.println("3. List Database");

            typeOfService = s.nextInt();
            switch (typeOfService) {
                case 0:
                   System.exit(0);
                case 1:
                    System.out.println("\t Product type: ");
                    System.out.println("\t 1.Alcoholic Drink ");
                    System.out.println("\t 2.Non-Alcoholic Drink ");
                    System.out.println("\t 3.Food ");
                    System.out.println("\t 4.Cleaning Product ");
                    int typeOfProduct=s.nextInt();
                    System.out.println("\t Name:");
                    String nameOfProduct = s.next();
                    System.out.println("\t Price:");
                    double priceOfProduct = s.nextDouble();



                        if(typeOfProduct==1) {
                            System.out.println("\t Alcohol percentage: ");
                            Product p = new Alcoholic(nameOfProduct, priceOfProduct, s.nextInt());
                            if (db.contains(p)) {
                                System.out.println("Product already in database. Aborting...");
                            } else
                                db.addProduct(p);

                        }
                        if(typeOfProduct==2) {
                            System.out.println("\t Beverage type: ");
                            Product p = new NonAlcoholic(nameOfProduct, priceOfProduct, s.next());
                            if(db.contains(p))
                            {
                                System.out.println("Product already in database. Aborting...");}
                            else {
                                db.addProduct(p);}
                        }
                        if(typeOfProduct==3)
                        {
                            Product p = new Food(nameOfProduct, priceOfProduct);
                            if(db.contains(p))
                            {
                                System.out.println("Product already in database. Aborting...");}
                            else {
                                db.addProduct(p);}
                        }
                        if(typeOfProduct==4)
                        {
                            System.out.println("\t Cleaning Product type: ");
                            Product p = new CleaningProducts(nameOfProduct, priceOfProduct, s.next());
                            if(db.contains(p))
                            {
                                System.out.println("Product already in database. Aborting...");}
                            else {
                                db.addProduct(p);}
                        }



                    break;
                case 2:
                    System.out.println("Name of the product you want to delete: ");
                    String itemToDelete = s.next();
                    if(db.contains(itemToDelete))
                    {
                        db.removeProduct(itemToDelete);
                    }
                    else
                        System.out.println("Product not in the DataBase!");
                    break;
                case 3:
                    System.out.println(db.getProductList());
                    break;

            }

        }
    }
}
