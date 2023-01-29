package ua.hillel.homeworks.homework36.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.hillel.homeworks.homework36.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
