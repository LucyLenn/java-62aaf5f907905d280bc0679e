package ua.hillel.homeworks.homework34.dataaccess.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ua.hillel.homeworks.homework34.dataaccess.entity.Order;

import java.util.List;
import java.util.Optional;

@Repository
public class BasicOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getOrders() {
        return entityManager.createNativeQuery(
                "SELECT id, name, date, cost FROM orders", Order.class).getResultList();
    }

    public Optional<Order> getById(long id) {
        return Optional.ofNullable(entityManager.find(Order.class, id));
    }

    public void add(Order order) {
        entityManager.createNativeQuery(
                "INSERT INTO orders values (?,?)")
                .setParameter(1, order.getDate())
                .setParameter(2, order.getCost())
                .executeUpdate();
    }
}
