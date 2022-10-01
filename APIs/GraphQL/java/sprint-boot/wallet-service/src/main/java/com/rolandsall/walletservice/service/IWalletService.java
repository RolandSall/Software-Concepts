package com.rolandsall.walletservice.service;

import com.rolandsall.walletservice.domain.Wallet;

import java.util.List;

public interface IWalletService {

    void createWallet(Wallet wallet);

    List<Wallet> findAll();

    Wallet findById(int id);

    Wallet addWallet(Wallet wallet);
}
