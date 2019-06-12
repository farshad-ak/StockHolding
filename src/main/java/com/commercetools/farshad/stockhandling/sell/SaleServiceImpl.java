package com.commercetools.farshad.stockhandling.sell;

import com.commercetools.farshad.stockhandling.sell.dto.TopSellingProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {


    @Autowired
    private SaleRepository saleRepository;

    /**
     * This method create a custom jpa query for finding Top 3 SellingProduct
     *
     * @param startDate start date of duration
     * @param endDate   End date of duration
     * @return it's returning a list of TopSellingProductsModel Object
     */
    @Override
    public List<TopSellingProductsModel> findTop3SellingProduct(LocalDateTime startDate, LocalDateTime endDate) {
        return saleRepository.findTopXSellingProduct(startDate, endDate, PageRequest.of(0, 3));
    }
}