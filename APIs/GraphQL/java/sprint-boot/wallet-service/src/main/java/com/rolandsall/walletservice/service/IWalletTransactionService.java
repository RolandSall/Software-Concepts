package com.rolandsall.walletservice.service;

import com.rolandsall.walletservice.domain.WalletTransaction;
import com.rolandsall.walletservice.repositories.IWalletTransactionRepository;

import java.util.List;

public interface IWalletTransactionService {



    void createTransactions(List<WalletTransaction> transaction);
}
