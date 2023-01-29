package ua.hillel.homeworks.homework36.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.hillel.homeworks.homework36.entity.Product;
import ua.hillel.homeworks.homework36.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Product> findById(@PathVariable(value = "id") long id) {
        return productRepository.findById(id);
    }

    @Secured("ROLE_ADMIN")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public void add(@RequestBody Product product) {
        productRepository.save(product);
    }

    @Secured("ROLE_ADMIN")
    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        productRepository.deleteById(id);
    }
}
