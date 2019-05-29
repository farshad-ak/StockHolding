package com.commercetools.farshad.stockhandling.stock;

public interface StockService {

    Stock save(Stock stock);

    Stock saveForUpdate(StockModel stockModel);

    ProductStockModel getProductInStock(String productId);

    ProductStatModel findStats(String time);
}