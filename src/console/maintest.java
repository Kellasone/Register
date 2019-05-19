package console;

import database.SqlDatabase;
import product.*;

import java.sql.SQLException;

public class maintest {
    public static void main(String[] args) throws SQLException{
        Product alcoholic = new Alcoholic("Tttimisoreeanaaa", 6, 5);
        Product nonalcoholic = new NonAlcoholic("Aaapa", 6, "softdrink");
        Product food = new Food("Aaalune", 5);
        Product cp = new CleaningProducts("Mmmatura", 5, "HouseKeeping");
        SqlDatabase db = new SqlDatabase();
         //   String productToRemove = "Aalune";
       // System.out.println(db.removeProduct(productToRemove)+" entries were deleted!");

        //System.out.println(db.contains("Matura"));
        Product newProduct;
        newProduct = db.getProduct("Aaalunee");
        //db.getProductList()
        //System.out.println(db.getProductList());
        System.out.println(db.contains("Timisoreanad"));
        newProduct = new Alcoholic("Timisoreanad", 5,5);
        db.addProduct(newProduct);
        System.out.println(db.contains("Timisoreanad"));
        db.removeProduct("Timisoreanad");System.out.println(db.contains("Timisoreanad"));

    }
}
