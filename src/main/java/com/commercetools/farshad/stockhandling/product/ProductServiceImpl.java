package com.commercetools.farshad.stockhandling.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Optional<Product> findById(String productId) {
        return productRepository.findById(productId);
    }
}