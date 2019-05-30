package com.commercetools.farshad.stockhandling.stock;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface StockRepository extends CrudRepository<Stock, Long> {

    /**
     * find a product with id in stock
     *
     * @param productId Product Id
     * @return product in Stock
     */
    Optional<Stock> findAllByProductId(String productId);


    /**
     * this method get top Available product in stock
     * @param startDate Start Date
     * @param endDate End Date
     * @param pageable Pagination
     * @return a List of Top  Available product in stock
     */
    List<Stock> findAllByAndLastUpdateStockGreaterThanEqualAndLastUpdateStockLessThanEqualOrderByQuantityDesc(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}