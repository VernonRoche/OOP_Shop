import java.util.List;

public class Stock {
    private List<Product> product_list;
    private final String name;
    private String address;

    public Stock(List<Product> product_list, String name, String address) {
        this.product_list = product_list;
        this.name = name;
        this.address = address;
    }

    public List<Product> getProduct_list() {
        return product_list;
    }

    public void setProduct_list(List<Product> product_list) {
        this.product_list = product_list;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
