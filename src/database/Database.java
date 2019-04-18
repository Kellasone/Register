package database;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Product> productList = new ArrayList<Product>();
    private static Database database;


    public static Database Database() {
        if(database == null) {
            database = new Database();
            return database;
        }
        return database;
    }




    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product p){
        productList.add(p);
    }

    public void removeProduct(Product p){
        productList.remove(p);
    }

    public void removeProduct(String nameOfProduct){
        int i;
        for(i =0;i <productList.size();i++)
        {if(productList.get(i).getName().equals(nameOfProduct))
            break;}
        productList.remove(i);
    }

    public boolean contains(Product p){
        for (int i=0;i<productList.size();i++)
        {
            if (productList.get(i).getName().equals(p.getName()))
                return true;

        }
        return false;
    }

    public boolean contains(String productName){
        for (int i=0;i<productList.size();i++)
        {
            if (productList.get(i).getName().equals(productName))
                return true;

        }
        return false;
    }


    public Product getProduct(String name){
        int i;
        for (i =0;i<productList.size();i++)
        {
           if( productList.get(i).getName().equals(name) )
               break;

        }
        return productList.get(i);
    }

}
