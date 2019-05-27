package com.commercetools.farshad.stockhandling.sell;

import com.commercetools.farshad.stockhandling.sell.Sale;
import com.commercetools.farshad.stockhandling.sell.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/sale")
    public Sale save(@RequestBody Sale sale){
        return saleService.save(sale);
    }

    @GetMapping("/sale/{id}")
    public Optional<Sale> getById(@PathVariable(value = "id") Long id){
        return saleService.find(id);
    }

    @GetMapping("/sale")
    public Iterable<Sale> getAll(){
        return saleService.findAll();
    }

    @DeleteMapping("/sale/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        saleService.delete(id);
    }

    @DeleteMapping("/sale")
    public void deleteAll(){
        saleService.deleteAll();
    }

    @GetMapping("/sale/count")
    public long count(){
        return saleService.count();
    }
}