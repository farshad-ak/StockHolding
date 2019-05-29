package com.commercetools.farshad.stockhandling.sell;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleService {
    List<TopSellingProductsModel> findTop3SellingProduct(LocalDateTime startDate, LocalDateTime endDate);
}