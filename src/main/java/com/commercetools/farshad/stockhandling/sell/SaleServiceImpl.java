package com.commercetools.farshad.stockhandling.sell;

import com.commercetools.farshad.stockhandling.sell.Sale;
import com.commercetools.farshad.stockhandling.sell.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Optional<Sale> find(Long id) {
        return saleRepository.findById(id);
    }

    @Override
    public Iterable<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
    saleRepository.deleteById(id);
    }

    @Override
    public void delete(Sale sale) {
        saleRepository.delete(sale);
    }

    @Override
    public void deleteAll() {
        saleRepository.deleteAll();
    }

    @Override
    public long count() {
        return saleRepository.count();
    }

}