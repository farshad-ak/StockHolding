package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockModel {
    private String id;
    private Date timestamp;
    private String productId;
    private Integer quantity;
}
