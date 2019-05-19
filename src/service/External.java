package service;

import database.Database;
import database.SqlDatabase;
import product.*;

import java.io.*;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class External {
    /* No longer needed
    public void importDatabase(String filePath, SqlDatabase db) throws IOException
    {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Product newProduct;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");
            switch (values[0]) {
                case "NonAlcoholic":
                    newProduct = new NonAlcoholic(values[1], parseFloat(values[2]), values[4]);
                    db.addProduct(newProduct);
                    break;
                case "Alcoholic":
                    newProduct = new Alcoholic(values[1], parseFloat(values[2]), parseInt(values[4]));
                    db.addProduct(newProduct);
                    break;
                case "Food":
                    newProduct = new Food(values[1], parseFloat(values[2]));
                    db.addProduct(newProduct);
                    break;
                case "CleaningProducts":
                    newProduct = new CleaningProducts(values[1], parseFloat(values[2]), values[4]);
                    db.addProduct(newProduct);
                    break;
            }
        }
        bufferedReader.close();
    }
     */
    public void exportDatabase(String filePath, Database db) throws IOException
    {
        FileWriter fw = new FileWriter(filePath,false);

        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        List<Product> tempProdList = db.getProductList();
        for (int i = 0 ; i< tempProdList.size();i++)

            printWriter.println(tempProdList.get(i));
        printWriter.flush();
        printWriter.close();
    }
}
