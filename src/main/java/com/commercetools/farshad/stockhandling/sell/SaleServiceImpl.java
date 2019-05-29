package com.commercetools.farshad.stockhandling.sell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {


    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<TopSellingProductsModel> findTop3SellingProduct() {
        return saleRepository.findTopXSellingProduct(PageRequest.of(0, 3));
    }
}