package com.rolandsall.walletservice.api.CurrencyController;


import com.rolandsall.walletservice.domain.Currency;
import com.rolandsall.walletservice.repositories.ICurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CurrencyController {

    private ICurrencyRepository currencyRepository;

    @Autowired
    public CurrencyController(ICurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @QueryMapping
    public List<Currency> getCurrencies(){
        return currencyRepository.findAll();
    }
    @QueryMapping
    public Currency getCurrenciesByCode(@Argument  String code){
        return currencyRepository.findById(code).orElseThrow(() -> new RuntimeException("Wallet Not Found"));
    }

}
