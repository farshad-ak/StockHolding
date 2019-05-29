package com.commercetools.farshad.stockhandling.sell;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends CrudRepository<Sale, Long> {
    @Query(value = "select new com.commercetools.farshad.stockhandling.sell.TopSellingProductsModel(ss.product.id,sum(ss.countOfItem)) " +
            " from Sale ss " +
            "where  ss.saleDate >= :startDate" +
            " and ss.saleDate <= :endDate " +
            "group by  ss.product " +
            "order by  sum(ss.countOfItem) desc"
    )
    List<TopSellingProductsModel> findTopXSellingProduct(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, Pageable pageable);
}