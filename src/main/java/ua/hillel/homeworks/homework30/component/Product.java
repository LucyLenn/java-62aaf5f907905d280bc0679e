package ua.hillel.homeworks.homework30.component;

import lombok.Getter;

@Getter
public class Product {
    private long id;
    private String name;
    private long cost;

    public Product(long id, String name, long cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
