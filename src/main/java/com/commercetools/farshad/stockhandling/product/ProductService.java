package com.commercetools.farshad.stockhandling.product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(String productId);



}