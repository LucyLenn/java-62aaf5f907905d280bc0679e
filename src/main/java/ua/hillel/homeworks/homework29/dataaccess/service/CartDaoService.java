package ua.hillel.homeworks.homework29.dataaccess.service;

import ua.hillel.homeworks.homework29.entity.Cart;

import java.util.Optional;

public interface CartDaoService extends DaoService<Cart> {

    @Override
    Optional<Cart> findById(long id);

    @Override
    void add(Cart cart);

    @Override
    void remove(long id);
}
