package com.commercetools.farshad.stockhandling.stock;

public interface StockService {

    /**
     * Save a Stock
     *
     * @param stock Stock Entity
     * @return Generated Stock Entity
     */
    Stock save(Stock stock);

    /**
     *  Update a record in Stock
     * @param stockModel Stock Model
     * @return Updated Record Or 204  Http status
     */
    Stock saveForUpdate(StockModel stockModel);

    /**
     *  Get A particular Product in Stock
     * @param productId Product Id
     * @return Product Stock Model Object
     */
    ProductStockModel getProductInStock(String productId);

    /**
     * Get Statistic from Stock
     * @param time today or Last month
     * @return ProductStatModel Object
     */
    ProductStatModel findStats(String time);
}