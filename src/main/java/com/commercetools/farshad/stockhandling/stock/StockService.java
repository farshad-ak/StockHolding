package com.commercetools.farshad.stockhandling.stock;

import com.commercetools.farshad.stockhandling.stock.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {

    Stock save(Stock stock);

    Stock saveForUpdate(StockModel stockModel);
}