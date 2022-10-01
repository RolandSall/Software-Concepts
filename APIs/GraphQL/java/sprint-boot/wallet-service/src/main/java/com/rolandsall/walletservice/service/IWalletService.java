package com.rolandsall.walletservice.service;

import com.rolandsall.walletservice.domain.Currency;
import com.rolandsall.walletservice.domain.Wallet;

import java.util.List;

public interface IWalletService {

    void createWallet(Wallet wallet);
}
