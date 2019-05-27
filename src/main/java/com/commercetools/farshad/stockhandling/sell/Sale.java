package com.commercetools.farshad.stockhandling.sell;

import com.commercetools.farshad.stockhandling.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id",
            foreignKey = @ForeignKey(name = "PRODUCT_ID_FK")
    )
    private Product product;

    private Integer countOfItem;

    private Double pricePerUnit;
    private Double totalPrice;
}
