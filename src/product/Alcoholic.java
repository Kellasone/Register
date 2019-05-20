package product;

public class Alcoholic extends Product {
    private double alcohol;

    public Alcoholic(String name, double price, int alcohol) {
        super(name, price);
        this.alcohol = alcohol;
        this.tva = 0.24;
        this.productType = "Alcoholic";
    }

    public Alcoholic() {
        this.tva = 0.24;
        this.productType = "Alcoholic";
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return this.getProductType() + "," +
                this.getName() + "," +
                this.getPrice() + "," +
                this.getTva() + "," +
                this.getAlcohol();
    }

}
