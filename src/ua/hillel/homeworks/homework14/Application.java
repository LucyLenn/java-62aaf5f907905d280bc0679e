package ua.hillel.homeworks.homework14;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product(ProductCategory.BOOK, 70.1F, false, LocalDate.of(2022, 1, 1)),
                new Product(ProductCategory.TOY, 475.0F, false, LocalDate.of(2021, 2, 12)),
                new Product(ProductCategory.BOOK, 45.12F, true, LocalDate.of(2019, 1, 4)),
                new Product(ProductCategory.BOOK, 260.5F, false, LocalDate.of(2022, 4, 5)),
                new Product(ProductCategory.TOY, 500.0F, true, LocalDate.of(2022, 1, 15)),
                new Product(ProductCategory.BOOK, 500.55F, true, LocalDate.of(2022, 2, 16)),
                new Product(ProductCategory.BOOK, 65.0F, false, LocalDate.of(2021, 11, 11))
        );

        Catalogue catalogue = new Catalogue(products);

        catalogue.getBooksFilterPrice().forEach(System.out::println);
        catalogue.getBooksDiscount().forEach(System.out::println);
        System.out.println(catalogue.getCheapestBook());
        catalogue.getLastThreeProducts().forEach(System.out::println);
        System.out.println(catalogue.sumBooksPrice());

        catalogue.groupByCategory().forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach(System.out::println);
        });
    }
}
