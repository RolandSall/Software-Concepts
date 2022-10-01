package com.rolandsall.walletservice.service;

import com.rolandsall.walletservice.domain.WalletTransaction;
import com.rolandsall.walletservice.repositories.IWalletTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class WalletTransactionService implements IWalletTransactionService{

    private IWalletTransactionRepository walletTransactionRepository;

    public WalletTransactionService(IWalletTransactionRepository walletTransactionRepository) {
        this.walletTransactionRepository = walletTransactionRepository;
    }

    @Override
    public void createTransactions(List<WalletTransaction> transaction) {
        walletTransactionRepository.saveAll(transaction);
    }
}
