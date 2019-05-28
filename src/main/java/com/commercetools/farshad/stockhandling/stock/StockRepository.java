package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.stock.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StockRepository extends CrudRepository<Stock, Long> {

    Optional<Stock> findAllByProductId(String productId);
}