package com.commercetools.farshad.stockhandling.product;

import com.commercetools.farshad.stockhandling.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    Optional<Product> find(Long id);

    Iterable<Product> findAll();

    void delete(Long id);

    void delete(Product product);

    void deleteAll();

    long count();



}