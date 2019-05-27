package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.stock.Stock;
import com.commercetools.farshad.stockhandling.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/stock")
    public Stock save(@RequestBody Stock stock){
        return stockService.save(stock);
    }

    @GetMapping("/stock/{id}")
    public Optional<Stock> getById(@PathVariable(value = "id") Long id){
        return stockService.find(id);
    }

    @GetMapping("/stock")
    public Iterable<Stock> getAll(){
        return stockService.findAll();
    }

    @DeleteMapping("/stock/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        stockService.delete(id);
    }

    @DeleteMapping("/stock")
    public void deleteAll(){
        stockService.deleteAll();
    }

    @GetMapping("/stock/count")
    public long count(){
        return stockService.count();
    }
}