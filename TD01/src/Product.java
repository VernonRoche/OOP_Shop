public class Product {
    private final int product_id;
    private final String name;
    private int quantity;
    static int id=0;

    public Product(String name, int quantity){
        this.name=name;
        this.quantity=quantity;
        this.product_id=id++;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
