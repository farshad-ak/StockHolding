package com.commercetools.farshad.stockhandling.product;

import com.commercetools.farshad.stockhandling.product.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findById(String productId);
}