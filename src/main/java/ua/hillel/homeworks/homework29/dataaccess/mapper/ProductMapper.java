package ua.hillel.homeworks.homework29.dataaccess.mapper;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;
import ua.hillel.homeworks.homework29.entity.Product;

import java.sql.ResultSet;


public class ProductMapper implements RowMapper<Product> {

    @Override
    @SneakyThrows
    public Product mapRow(ResultSet rs, int rowNum) {

        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getBigDecimal("price"));

        return product;
    }
}
