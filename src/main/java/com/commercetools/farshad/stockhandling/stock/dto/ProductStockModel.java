package com.commercetools.farshad.stockhandling.stock.dto;

import com.commercetools.farshad.stockhandling.stock.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockModel {
    private String productId;
    private Date requestTimestamp;
    private Stock stock;
}
