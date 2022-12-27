package ua.hillel.homeworks.homework28.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.hillel.homeworks.homework28.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private final ProductRepository productRepository;
    private final List<Product> productCart = new ArrayList<>();

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductCart() {
        return productCart;
    }

    public void addById(int id) {
        productRepository.getById(id).ifPresent(productCart::add);
    }

    public void removeById(int id) {
        productRepository.getById(id).ifPresent(productCart::remove);
    }

    public void printProductCart() {
        getProductCart().forEach(System.out::println);
    }
}
