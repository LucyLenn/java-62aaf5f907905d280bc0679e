package ua.hillel.homeworks.homework14;

import java.time.LocalDate;
import java.util.UUID;

public class Product {
    private final ProductCategory category;
    private final UUID id;
    private float price;
    private boolean discountable;
    private LocalDate dateAdded;

    public Product(ProductCategory category, float price, boolean discountable, LocalDate dateAdded) {
        this.category = category;
        this.price = price;
        this.discountable = discountable;
        this.dateAdded = dateAdded;
        id = UUID.randomUUID();
    }

    public ProductCategory getCategory() {
        return category;
    }

    public UUID getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isDiscountable() {
        return discountable;
    }

    public void setDiscountable(boolean discountable) {
        this.discountable = discountable;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void applyDiscount() {
        price *= 0.9F;
    }

    @Override
    public String toString() {
        return '{' +
                "category=" + category +
                ", price=" + String.format("%.2f", price).replace(',', '.') +
                ", isDiscounted=" + discountable +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
