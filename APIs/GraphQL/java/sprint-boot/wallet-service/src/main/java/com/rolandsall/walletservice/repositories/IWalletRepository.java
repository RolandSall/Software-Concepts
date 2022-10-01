package com.rolandsall.walletservice.repositories;

import com.rolandsall.walletservice.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWalletRepository extends JpaRepository<Wallet,String> {
}
