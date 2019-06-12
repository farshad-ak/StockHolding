package com.commercetools.farshad.stockhandling.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopSellingProductsModel {
    private String productId;
    private Long itemsSold;
}
