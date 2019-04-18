package product;

public class CleaningProducts extends Product{
    private String type;

    public CleaningProducts(String name, double price, String type) {
        super(name, price);
        this.type = type;
        this.tva=0.24;
        this.productType ="CleaningProducts";
    }


    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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
