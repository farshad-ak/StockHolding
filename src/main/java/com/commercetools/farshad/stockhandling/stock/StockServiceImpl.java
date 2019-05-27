package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.stock.Stock;
import com.commercetools.farshad.stockhandling.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Optional<Stock> find(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public Iterable<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public void delete(Long id) {
    stockRepository.deleteById(id);
    }

    @Override
    public void delete(Stock stock) {
        stockRepository.delete(stock);
    }

    @Override
    public void deleteAll() {
        stockRepository.deleteAll();
    }

    @Override
    public long count() {
        return stockRepository.count();
    }

}