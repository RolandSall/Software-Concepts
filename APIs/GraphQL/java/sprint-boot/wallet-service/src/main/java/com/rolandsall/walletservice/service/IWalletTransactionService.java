package com.rolandsall.walletservice.service;

import com.rolandsall.walletservice.enums.domain.WalletTransaction;

import java.util.List;

public interface IWalletTransactionService {



    void createTransactions(List<WalletTransaction> transaction);
}
