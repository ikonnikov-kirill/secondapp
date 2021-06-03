import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
@Scope(value = "prototype")
public class Cart {


    private final List<CartEntity> cart;

    public Cart() {
        this.cart = new ArrayList<>();
    }

    public boolean remove(Product product) {
        Optional<CartEntity> cartEntity = cart.stream()
                .filter(ce -> ce.getProduct().equals(product))
                .findAny();

        if (cartEntity.isPresent()) {
            if (cartEntity.get().getAmount() <= 1) {
                return cart.remove(cartEntity.get());
            } else {
                cartEntity.get().decAmount();
            }
        } else {
            return false;
        }
        return cart.remove(product);
    }

    public void add(Product product) {
        Optional<Product> pr = cart.stream()
                .map(cartEntity -> cartEntity.getProduct())
                .filter(p -> p.equals(product))
                .findAny();

        if (pr.isEmpty()) {
            cart.add(new CartEntity(product));
        } else {
            cart.stream().
                    filter(cartEntity -> cartEntity.getProduct().equals(product))
                    .forEach(cartEntity -> cartEntity.incAmount());
        }
    }

    public void remove(int index) throws Exception {
        if (index > cart.size() -1) throw new Exception("No such element in cart");

        if (cart.get(index).getAmount() <= 1) {
            cart.remove(index);
        } else {
            cart.get(index).decAmount();        }

    }

    public void removeAll(int index) throws Exception {
        if (index > cart.size() -1) throw new Exception("No such element in cart");
        cart.remove(index);
    }


    public double getTotal() {
        double total = 0;
        for (CartEntity ce : cart) {
            total += ce.getAmount() * ce.getProduct().getPrice();
        }
        return total;
    }

    public void clear() {
        cart.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger numInCart = new AtomicInteger(0);
        sb.append("Cart:\n")
                .append(
                        cart.stream()
                                .map(ce ->
                                        String.format("%-5d %s Amount: %-3d pcs", numInCart.incrementAndGet(), ce.getProduct(), ce.getAmount())
                                )
                                .collect(Collectors.joining("\n"))
                );
        sb.append(
                String.format("\nTotal: %-5.2f $", getTotal())
        );
        return sb.toString();
    }
}
