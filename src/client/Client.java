package client;

import product.Food;
import product.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {
    private ArrayList<HashMap<Integer, Product> > clientProducts = new ArrayList<>();
    private static int client =0;
    private int clientNumber;

    public Client() {
        this.clientNumber = ++client;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public ArrayList< HashMap<Integer, Product> > getClientProducts() {
        return clientProducts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Client Number=" + clientNumber +
                '}';
    }

    public void addProduct(Product productToAdd, int numberOfProducts)
    {
        HashMap<Integer, Product> productMap = new HashMap<Integer, Product>();
        productMap.put(numberOfProducts, productToAdd);
        clientProducts.add(productMap);
    }


    public void removeProduct(HashMap<Integer, Product> productHashMap) {
        clientProducts.remove(productHashMap);
    }
}
