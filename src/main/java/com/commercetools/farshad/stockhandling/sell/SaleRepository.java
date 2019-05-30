package com.commercetools.farshad.stockhandling.sell;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends CrudRepository<Sale, Long> {

    /**
     * This method create a custom jpa query for finding Top X SellingProduct
     *
     * @param startDate start date of duration
     * @param endDate   End date of duration
     * @param pageable  limitation for finding
     * @return it's returning a list of TopSellingProductsModel Object
     */
    @Query(value = "select new com.commercetools.farshad.stockhandling.sell.TopSellingProductsModel(ss.product.id,sum(ss.countOfItem)) " +
            " from Sale ss " +
            "where  ss.saleDate >= :startDate" +
            " and ss.saleDate <= :endDate " +
            "group by  ss.product " +
            "order by  sum(ss.countOfItem) desc"
    )
    List<TopSellingProductsModel> findTopXSellingProduct(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, Pageable pageable);
}