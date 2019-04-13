package Product;

public class Food extends Product {

    public Food(String name, double price) {
        super(name, price);

    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Price: " + Double.toString(this.price);
    }
}
