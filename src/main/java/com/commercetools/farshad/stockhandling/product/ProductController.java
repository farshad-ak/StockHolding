package com.commercetools.farshad.stockhandling.product;

import com.commercetools.farshad.stockhandling.product.Product;
import com.commercetools.farshad.stockhandling.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getById(@PathVariable(value = "id") Long id) {
        return productService.find(id);
    }

    @GetMapping("/product")
    public Iterable<Product> getAll() {
        return productService.findAll();
    }

    @DeleteMapping("/product/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        productService.delete(id);
    }

    @DeleteMapping("/product")
    public void deleteAll() {
        productService.deleteAll();
    }

    @GetMapping("/product/count")
    public long count() {
        return productService.count();
    }

}