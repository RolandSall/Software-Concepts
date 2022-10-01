package com.rolandsall.walletservice.repositories;

import com.rolandsall.walletservice.domain.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
}
