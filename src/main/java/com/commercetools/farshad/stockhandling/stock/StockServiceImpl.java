package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.product.Product;
import com.commercetools.farshad.stockhandling.product.ProductRepository;
import com.commercetools.farshad.stockhandling.stock.Stock;
import com.commercetools.farshad.stockhandling.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

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

}