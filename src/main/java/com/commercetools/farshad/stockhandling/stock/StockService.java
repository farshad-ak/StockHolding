package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.stock.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {

    Stock save(Stock stock);

    Optional<Stock> find(Long id);

    Iterable<Stock> findAll();

    void delete(Long id);

    void delete(Stock stock);

    void deleteAll();

    long count();

}