package com.commercetools.farshad.stockhandling.product;

import java.util.Optional;

public interface ProductService {
    /**
     * Find a product with string ID
     *
     * @param productId porduct ID
     * @return Optional object of Product
     */
    Optional<Product> findById(String productId);

}