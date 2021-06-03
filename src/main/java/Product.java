import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("id: %-3d name: %-15s price: %-5.2f $", id, name, price);
    }
}
