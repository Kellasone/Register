package service;

import product.*;

import java.io.*;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class External extends console.Main  {




    public void importDatabase(String filePath) throws IOException
    {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");

            switch (values[0]) {
                case "NonAlcoholic":
                    this.newProduct = new NonAlcoholic(values[1], parseFloat(values[2]), values[4]);
                    this.db.addProduct(this.newProduct);
                    break;
                case "Alcoholic":
                    this.newProduct = new Alcoholic(values[1], parseFloat(values[2]), parseInt(values[4]));
                    this.db.addProduct(this.newProduct);
                    break;
                case "Food":
                    this.newProduct = new Food(values[1], parseFloat(values[2]));
                    this.db.addProduct(this.newProduct);
                    break;
                case "CleaningProducts":
                    this.newProduct = new CleaningProducts(values[1], parseFloat(values[2]), values[4]);
                    this.db.addProduct(this.newProduct);
                    break;
            }


        }
        bufferedReader.close();
    }

    public void exportDatabase(String filePath) throws IOException
    {
        FileWriter fw = new FileWriter(filePath,false);

        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        List<Product> tempProdList = this.db.getProductList();
        for (int i = 0 ; i< tempProdList.size();i++)

            printWriter.println(tempProdList.get(i));
        printWriter.flush();
        printWriter.close();
    }
}
