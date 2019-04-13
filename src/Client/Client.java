package Client;

import Product.Product;
import Database.Database;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private ArrayList<Product> clientProducts = new ArrayList<Product>();


    public ArrayList<Product> getClientList()
    {
        return clientProducts;
    }
   public void addClientProduct(Product p, int x){
        clientProducts.add(p);
    }

}
