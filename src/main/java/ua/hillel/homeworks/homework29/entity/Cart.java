package ua.hillel.homeworks.homework29.entity;

import java.util.ArrayList;
import java.util.List;


public class Cart {
    private final List<Product> productCart = new ArrayList<>();
    private long id;

    public List<Product> getProductCart() {
        return productCart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
