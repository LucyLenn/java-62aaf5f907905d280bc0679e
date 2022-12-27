package ua.hillel.homeworks.homework28.component;

import org.springframework.stereotype.Component;
import ua.hillel.homeworks.homework28.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();

    public Optional<Product> getById(int id) {
        return productList.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Product> getAll() {
        return productList;
    }

    @PostConstruct
    public void fillProductRepository() {
        productList.add(new Product(1, "name1", 100));
        productList.add(new Product(2, "name2", 150));
        productList.add(new Product(3, "name3", 90));
        productList.add(new Product(4, "name4", 125));
    }
}
