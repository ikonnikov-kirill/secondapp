import lombok.Getter;

@Getter
public class CartEntity {
    private ru.ntr.lesson2.Product product;
    private int amount;

    public CartEntity(ru.ntr.lesson2.Product product) {
        this.product = product;
        amount++;
    }

    public void incAmount() {
        amount++;
    }

    public void decAmount() {
        if (amount > 0) {
            amount --;
        }
    }
}
