package com.rolandsall.walletservice.service;

import com.rolandsall.walletservice.enums.domain.Wallet;
import com.rolandsall.walletservice.repositories.ICurrencyRepository;
import com.rolandsall.walletservice.repositories.IWalletRepository;
import com.rolandsall.walletservice.repositories.IWalletTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WalletService implements IWalletService{


    private IWalletRepository walletRepository;
    private ICurrencyRepository currencyRepository;
    private IWalletTransactionRepository walletTransactionRepository;


    public WalletService(IWalletRepository walletRepository, ICurrencyRepository currencyRepository, IWalletTransactionRepository walletTransactionRepository) {
        this.walletRepository = walletRepository;
        this.currencyRepository = currencyRepository;
        this.walletTransactionRepository = walletTransactionRepository;
    }

    @Override
    public void createWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }
}