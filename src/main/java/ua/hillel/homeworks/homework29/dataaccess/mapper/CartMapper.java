package ua.hillel.homeworks.homework29.dataaccess.mapper;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.ResultSetExtractor;
import ua.hillel.homeworks.homework29.entity.Cart;
import ua.hillel.homeworks.homework29.entity.Product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartMapper implements ResultSetExtractor<Cart> {

    @Override
    @SneakyThrows
    public Cart extractData(ResultSet rs) {
        List<Product> productCart = new ArrayList<>();

        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getLong("product_id"));
            product.setName(rs.getString("p_name"));
            product.setPrice(rs.getBigDecimal("p_price"));
            productCart.add(product);
        }

        Cart cart = new Cart();
        cart.setId(rs.getLong("cart_id"));
        cart.getProductCart().addAll(productCart);
        return cart;
    }
}
