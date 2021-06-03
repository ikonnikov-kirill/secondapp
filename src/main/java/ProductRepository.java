import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("repository")
@Getter
public class ProductRepository {
    private final List<Product> productRepository;

    public ProductRepository() {
        this.productRepository = new ArrayList<>();
        productRepository.add(Product.builder()
                .id(0)
                .name("Pear")
                .price(1.23)
                .build());
        productRepository.add(Product.builder()
                .id(1)
                .name("Cabbage")
                .price(0.76)
                .build());
        productRepository.add(Product.builder()
                .id(2)
                .name("Cherry")
                .price(2.45)
                .build());
        productRepository.add(Product.builder()
                .id(3)
                .name("Peach")
                .price(3.58)
                .build());
        productRepository.add(Product.builder()
                .id(4)
                .name("strawberry")
                .price(5.54)
                .build());
    }

    public Optional<Product> getById(int id) {
        return productRepository.stream().filter(p -> p.getId() == id).findFirst();
    }

    public boolean remove(Product product) {
        return remove(product);
    }

    public boolean removeById(int id) {
        return productRepository.removeIf(p -> p.getName().equals(id));
    }

    public boolean removeByName(String name) {
        return productRepository.removeIf(p -> p.getName().equals(name));
    }

    public boolean removeAll(Product... products) {
        return productRepository.removeAll(Arrays.asList(products));
    }

    public boolean removeAll(List<Product> products) {
        return productRepository.removeAll(products);
    }

    public boolean add(Product product) {
        return productRepository.add(product);
    }

    public boolean addAll(Product... products) {
        return productRepository.addAll(Arrays.asList(products));
    }

    public boolean addAll(List<Product> products) {
        return productRepository.addAll(products);
    }

    public void clear() {
        productRepository.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalog:\n")
                .append(
                        productRepository.stream()
                                .map(p -> p.toString())
                                .collect(Collectors.joining("\n"))
                );
        return sb.toString();
    }
}
