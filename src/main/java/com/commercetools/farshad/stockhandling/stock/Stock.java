package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.product.Product;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("timestamp")
    private Date lastUpdateStock;

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    @JsonIgnore
    @Version
    private Long version;
}
