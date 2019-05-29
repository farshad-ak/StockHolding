package com.commercetools.farshad.stockhandling.sell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {


    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<TopSellingProductsModel> findTop3SellingProduct(LocalDateTime startDate, LocalDateTime endDate) {
        return saleRepository.findTopXSellingProduct(startDate, endDate, PageRequest.of(0, 3));
    }
}