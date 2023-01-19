package ua.hillel.homeworks.homework32.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.hillel.homeworks.homework32.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
