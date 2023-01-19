package ua.hillel.homeworks.homework32.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.hillel.homeworks.homework32.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
