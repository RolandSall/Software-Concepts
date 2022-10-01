package com.rolandsall.walletservice.repositories;

import com.rolandsall.walletservice.enums.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICurrencyRepository extends JpaRepository<Currency,String> {
}
