package product;

public class NonAlcoholic extends Product {
    private String type;


    public NonAlcoholic() {
        this.tva = 0.09;
        this.productType = "NonAlcoholic";
    }

    public NonAlcoholic(String name, double price, String type) {
        super(name, price);

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getProductType() + "," +
                this.getName() + "," +
                this.getPrice() + "," +
                this.getTva() + "," +
                this.getType();
    }
}
