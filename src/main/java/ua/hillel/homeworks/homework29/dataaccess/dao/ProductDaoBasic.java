package ua.hillel.homeworks.homework29.dataaccess.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.hillel.homeworks.homework29.dataaccess.mapper.ProductMapper;
import ua.hillel.homeworks.homework29.dataaccess.service.ProductDaoService;
import ua.hillel.homeworks.homework29.entity.Product;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoBasic implements ProductDaoService {

    private static final String FIND_BY_ID_QUERY = "SELECT id, name, price FROM products WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT id, name, price FROM products";
    private static final String INSERT_QUERY = "INSERT INTO products (name, price) VALUES (?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM products WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public ProductDaoBasic(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, new ProductMapper(), id));
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, new ProductMapper());
    }

    @Override
    public void add(Product product) {
        jdbcTemplate.update(INSERT_QUERY, product.getName(), product.getPrice());
    }

    @Override
    public void remove(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}
