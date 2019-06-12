package com.commercetools.farshad.stockhandling.stock.dto;

import com.commercetools.farshad.stockhandling.sell.dto.TopSellingProductsModel;
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
