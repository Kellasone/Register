package Product;

public class Alcoholic extends Product {
    private int alcohol;

    public Alcoholic(String name, double price, int alcohol) {
        super(name, price);
        this.alcohol = alcohol;
        this.tva = 0.24;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Price: " + Double.toString(this.price) + " Alcohol: " + this.alcohol;
    }
}
