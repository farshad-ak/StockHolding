package com.commercetools.farshad.stockhandling.sell;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleService {
    /**
     * This method create a custom jpa query for finding Top 3 SellingProduct
     *
     * @param startDate start date of duration
     * @param endDate   End date of duration
     * @return it's returning a list of TopSellingProductsModel Object
     */
    List<TopSellingProductsModel> findTop3SellingProduct(LocalDateTime startDate, LocalDateTime endDate);
}