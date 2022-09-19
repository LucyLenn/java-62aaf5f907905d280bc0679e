package ua.hillel.homeworks.homework14;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Catalogue {
    private final List<Product> products;

    public Catalogue(List<Product> products) {
        this.products = products;
    }

    public List<Product> getBooksFilterPrice() {
        return products.stream()
                .filter(p -> p.getCategory() == ProductCategory.BOOK && p.getPrice() > 250)
                .toList();
    }

    public List<Product> getBooksDiscount() {
        return products.stream()
                .filter(p -> p.getCategory() == ProductCategory.BOOK && p.isDiscountable())
                .peek(Product::applyDiscount)
                .toList();
    }

    public Product getCheapestBook() {
        return products.stream()
                .filter(p -> p.getCategory() == ProductCategory.BOOK)
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product category BOOK not found"));
    }

    public List<Product> getLastThreeProducts() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .toList();
    }

    public float sumBooksPrice() {
        return products.stream()
                .filter(p -> p.getCategory() == ProductCategory.BOOK
                        && p.getDateAdded().getYear() == LocalDate.now().getYear()
                        && p.getPrice() <= 75)
                .map(Product::getPrice)
                .reduce(0F, Float::sum);
    }

    public Map<ProductCategory, List<Product>> groupByType() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }
}
