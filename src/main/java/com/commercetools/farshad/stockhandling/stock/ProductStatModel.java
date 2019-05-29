package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.sell.TopSellingProductsModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductStatModel {
    private LocalDateTime requestTimestamp;
    private String range;
    private List<StockModel> topAvailableProducts;
    private List<TopSellingProductsModel> topSellingProducts;
}
