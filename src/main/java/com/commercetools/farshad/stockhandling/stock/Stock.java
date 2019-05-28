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
@Entity
public class Stock {
    @Id
   private String id;


    private Date lastUpdateStock;


    @OneToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    @Version
    private Long version;
}
