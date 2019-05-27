package com.commercetools.farshad.stockhandling.sell;

import com.commercetools.farshad.stockhandling.sell.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleService {

    Sale save(Sale sale);

    Optional<Sale> find(Long id);

    Iterable<Sale> findAll();

    void delete(Long id);

    void delete(Sale sale);

    void deleteAll();

    long count();

}