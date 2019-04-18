package product;

public class NonAlcoholic extends Product{
    private String type;


    public NonAlcoholic(String name, double price, String type) {
        super(name, price);
        this.type = type;
        this.tva = 0.09;
        this.productType ="NonAlcoholic";
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.getProductType() +","+
                this.getName()+","+
                this.getPrice()+","+
                this.getTva()+","+
                this.getType();
    }
}
