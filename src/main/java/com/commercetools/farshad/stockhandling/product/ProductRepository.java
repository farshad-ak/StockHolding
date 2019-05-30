package com.commercetools.farshad.stockhandling.product;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    /**
     * Find a product with string ID
     *
     * @param productId porduct ID
     * @return Optional object of Product
     */
    Optional<Product> findById(String productId);
}