package com.rolandsall.walletservice.service;

import com.rolandsall.walletservice.domain.Currency;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICurrencyService {
    void createCurrencies(List<Currency> currency);
}
