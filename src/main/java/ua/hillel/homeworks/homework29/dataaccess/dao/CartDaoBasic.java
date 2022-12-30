package ua.hillel.homeworks.homework29.dataaccess.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.hillel.homeworks.homework29.dataaccess.mapper.CartMapper;
import ua.hillel.homeworks.homework29.dataaccess.service.CartDaoService;
import ua.hillel.homeworks.homework29.entity.Cart;
import ua.hillel.homeworks.homework29.entity.Product;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class CartDaoBasic implements CartDaoService {

    private static final String FIND_BY_ID_QUERY =
            "SELECT cart_id, product_id, products.name as p_name, products.price as p_price " +
                    "FROM cart_products JOIN products on cart_products.product_id = products.id " +
                    "WHERE cart_id = ?";
    private static final String INSERT_QUERY = "INSERT INTO cart_products (cart_id, product_id) VALUES (?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM carts WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public CartDaoBasic(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Cart> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.query(FIND_BY_ID_QUERY, new CartMapper(), id));
    }

    @Override
    public void add(Cart cart) {
        List<Product> productCart = cart.getProductCart();

        jdbcTemplate.batchUpdate(INSERT_QUERY,
                productCart,
                50,
                (PreparedStatement ps, Product product) -> {
                    ps.setLong(1, cart.getId());
                    ps.setLong(2, product.getId());
                });
    }

    @Override
    public void remove(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}
