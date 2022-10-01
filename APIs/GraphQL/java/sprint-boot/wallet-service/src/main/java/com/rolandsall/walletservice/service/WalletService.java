package com.rolandsall.walletservice.service;

import com.rolandsall.walletservice.domain.Wallet;
import com.rolandsall.walletservice.repositories.ICurrencyRepository;
import com.rolandsall.walletservice.repositories.IWalletRepository;
import com.rolandsall.walletservice.repositories.IWalletTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet findById(int id) {
        return walletRepository.findById(id).orElseThrow(() -> new RuntimeException("Wallet Not Found"));
    }

    @Override
    public Wallet addWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }
}
