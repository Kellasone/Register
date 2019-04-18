package product;

public class Food extends Product {

    public Food(String name, double price) {
        super(name, price);
        this.tva = 0.09;
        this.productType ="Food";
    }

    @Override
    public String toString() {
        return this.getProductType() +","+
                this.getName()+","+
                this.getPrice()+","+
                this.getTva();
    }
}
