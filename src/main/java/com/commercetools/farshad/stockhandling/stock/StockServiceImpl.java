package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.product.Product;
import com.commercetools.farshad.stockhandling.product.ProductRepository;
import com.commercetools.farshad.stockhandling.sell.SaleService;
import com.commercetools.farshad.stockhandling.sell.TopSellingProductsModel;
import com.commercetools.farshad.stockhandling.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleService saleService;

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock saveForUpdate(StockModel stockModel) {
        Stock saved = new Stock();
        Stock productStock;
        Optional<Stock> byProductId = stockRepository.findAllByProductId(stockModel.getProductId());
        if (byProductId.isPresent()) {
            productStock = byProductId.get();
            productStock.setLastUpdateStock(stockModel.getTimestamp());
        } else {
            Optional<Product> product = productRepository.findById(stockModel.getProductId());
            if (product.isPresent()) {
                productStock = new Stock();
                productStock.setLastUpdateStock(stockModel.getTimestamp());
                productStock.setProduct(product.get());
            } else {
                return saved;
            }
        }
        productStock.setId(stockModel.getId());
        productStock.setQuantity(stockModel.getQuantity());
        productStock.setLastUpdateStock(stockModel.getTimestamp());
        saved = stockRepository.save(productStock);
        return saved;
    }

    @Override
    public ProductStockModel getProductInStock(String productId) {
        Optional<Stock> productInStockByProductId = stockRepository.findAllByProductId(productId);
        ProductStockModel productStockModel = new ProductStockModel();
        if (productInStockByProductId.isPresent()) {
            productStockModel.setProductId(productInStockByProductId.get().getProduct().getId());
            productStockModel.setRequestTimestamp(new Date());
            productStockModel.setStock(productInStockByProductId.get());
        }
        return productStockModel;
    }

    @Override
    public ProductStatModel findStats(String time) {
        ProductStatModel productStat = new ProductStatModel();
        productStat.setRange(time);
        productStat.setRequestTimestamp(LocalDateTime.now());
//--------------------------
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = LocalDateTime.now();
        if ("lastMonth".equalsIgnoreCase(time)) {
            startDate = DateUtil.getPreviousMonth()[0];
            endDate = DateUtil.getPreviousMonth()[1];
        } else if ("today".equalsIgnoreCase(time)) {
            startDate = DateUtil.getTodayStartAndNow()[0];
            endDate = DateUtil.getTodayStartAndNow()[1];
        }


//--------------------------
        List<TopSellingProductsModel> top3SellingProduct = saleService.findTop3SellingProduct(startDate, endDate);
//--------------------------
        List<Stock> topXAvailableProduct = stockRepository.findAllByAndLastUpdateStockGreaterThanEqualAndLastUpdateStockLessThanEqualOrderByQuantityDesc(
                startDate, endDate, PageRequest.of(0, 3));
        List<StockModel> top3AvailableProduct = new ArrayList<>();
        topXAvailableProduct.forEach(stock -> {
            top3AvailableProduct.add(new StockModel(stock.getId(), stock.getLastUpdateStock(), stock.getProduct().getId(), stock.getQuantity()));
        });
//--------------------------
        productStat.setTopAvailableProducts(top3AvailableProduct);
        productStat.setTopSellingProducts(top3SellingProduct);
        return productStat;
    }


}