package com.commercetools.farshad.stockhandling.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockModel {
    private String id;
    private LocalDateTime timestamp;
    private String productId;
    private Integer quantity;
}
