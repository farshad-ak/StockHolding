package com.commercetools.farshad.stockhandling.product;

import com.commercetools.farshad.stockhandling.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}