package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.stock.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
}