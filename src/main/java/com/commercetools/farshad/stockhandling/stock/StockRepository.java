package com.commercetools.farshad.stockhandling.stock;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface StockRepository extends CrudRepository<Stock, Long> {

    Optional<Stock> findAllByProductId(String productId);

    List<Stock> findAllByAndLastUpdateStockGreaterThanEqualAndLastUpdateStockLessThanEqualOrderByQuantityDesc(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}