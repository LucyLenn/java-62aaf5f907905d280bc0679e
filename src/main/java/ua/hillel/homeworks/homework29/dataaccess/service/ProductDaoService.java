package ua.hillel.homeworks.homework29.dataaccess.service;

import ua.hillel.homeworks.homework29.entity.Product;

import java.util.List;
import java.util.Optional;


public interface ProductDaoService extends DaoService<Product> {

    @Override
    Optional<Product> findById(long id);

    List<Product> findAll();

    @Override
    void add(Product product);

    @Override
    void remove(long id);

}
