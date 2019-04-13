package Product;

public class Product {
    protected String name;
    protected double price;
    protected double tva;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getTva() {
        return tva;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }


}