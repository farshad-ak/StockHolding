package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.stock.Stock;
import com.commercetools.farshad.stockhandling.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/updateStock")
    public ResponseEntity<Stock> save(@RequestBody StockModel stock) {
        try {
            Stock saveForUpdate = stockService.saveForUpdate(stock);
            ResponseEntity<Stock> res = new ResponseEntity<>(saveForUpdate, HttpStatus.CREATED);
            return res;
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "outdated stock, because a newer stock was processed first", ex);
        }
    }

}
