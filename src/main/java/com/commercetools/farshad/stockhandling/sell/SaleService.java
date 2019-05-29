package com.commercetools.farshad.stockhandling.sell;

import java.util.List;

public interface SaleService {
    List<TopSellingProductsModel> findTop3SellingProduct();
}