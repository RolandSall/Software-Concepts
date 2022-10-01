package com.rolandsall.walletservice.service;


import com.rolandsall.walletservice.domain.Currency;
import com.rolandsall.walletservice.repositories.ICurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CurrencyService implements ICurrencyService {

    private ICurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(ICurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public void createCurrencies(List<Currency> currency) {
        currencyRepository.saveAll(currency);
    }
}
