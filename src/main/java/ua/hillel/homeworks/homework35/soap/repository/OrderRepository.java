package ua.hillel.homeworks.homework35.soap.repository;


import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;
import ua.ithillel.soap.webservice.homework35.Order;
import ua.ithillel.soap.webservice.homework35.Product;

import javax.xml.datatype.DatatypeFactory;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    @PostConstruct
    @SneakyThrows
    public void initData() {
        Order order1 = new Order();
        order1.setId(1L);
        order1.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
        order1.setCost(100L);

        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("name1");
        product1.setCost(10L);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("name2");
        product2.setCost(15L);


        order1.getProduct().addAll(List.of(product1, product2));

        Order order2 = new Order();
        order2.setId(2L);
        order2.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
        order2.setCost(200L);
        order2.getProduct().add(product1);

        orders.add(order1);
        orders.add(order2);
    }

    public Optional<Order> getOrderById(long id) {
        return orders.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void add(Order order) {
        orders.add(order);
    }
}
