package com.commercetools.farshad.stockhandling.stock;


import com.commercetools.farshad.stockhandling.sell.SaleService;
import com.commercetools.farshad.stockhandling.stock.dto.ProductStatModel;
import com.commercetools.farshad.stockhandling.stock.dto.ProductStockModel;
import com.commercetools.farshad.stockhandling.stock.dto.StockModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.OptimisticLockException;


@RestController
@RequestMapping("")
public class StockController {
    private static Logger logger = LoggerFactory.getLogger(StockController.class);

    @Autowired
    private StockService stockService;

    @Autowired
    private SaleService saleService;


    /**
     * This endpoint updates the current stock of a particular product
     *
     * @param stock Stock Object
     * @return ResponseEntity<Stock>
     */
    @PostMapping("/updateStock")
    public ResponseEntity<Stock> save(@RequestBody StockModel stock) {
        try {
            Stock saveForUpdate = stockService.saveForUpdate(stock);
            ResponseEntity<Stock> res = new ResponseEntity<>(saveForUpdate, HttpStatus.CREATED);
            logger.info("Successfully updated");
            return res;
        } catch (OptimisticLockException ex) {
            logger.error("OptimisticLockException", ex);
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "outdated stock, because a newer stock was processed first", ex);
        } catch (Exception ex) {
            logger.error("Exception", ex);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", ex);
        }
    }

    /**
     * you get the current stock available of a particular
     * product
     *
     * @param productId particular product
     * @return ProductStockModel
     */
    @GetMapping("/stock")
    public ResponseEntity<ProductStockModel> getProductInStock(@RequestParam("productId") String productId) {
        try {
            ProductStockModel productInStock = stockService.getProductInStock(productId);
            ResponseEntity<ProductStockModel> res = new ResponseEntity<>(productInStock, HttpStatus.OK);
            logger.info("Successfully get product");
            return res;
        } catch (Exception ex) {
            logger.error("Exception", ex);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", ex);
        }
    }


    /**
     * When calling this endpoint, we want to receive some statistics about our stocks back. The
     * available timespans are today (midnight until now) and last month.
     *
     * @param time today (midnight until now) and last month.
     * @return top selling and top available product in stock
     */
    @GetMapping("/statistics")
    public ResponseEntity<ProductStatModel> getStockStatistic(@RequestParam("time") String time) {
        try {
            ProductStatModel stats = stockService.findStats(time);
            ResponseEntity<ProductStatModel> res = new ResponseEntity<>(stats, HttpStatus.OK);
            return res;
        } catch (Exception ex) {
            logger.error("Exception", ex);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", ex);
        }
    }

}
