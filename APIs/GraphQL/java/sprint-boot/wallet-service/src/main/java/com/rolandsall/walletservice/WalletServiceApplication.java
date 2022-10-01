package com.rolandsall.walletservice;
import com.rolandsall.walletservice.domain.Currency;
import com.rolandsall.walletservice.domain.Wallet;
import com.rolandsall.walletservice.domain.WalletTransaction;
import com.rolandsall.walletservice.service.ICurrencyService;
import com.rolandsall.walletservice.service.IWalletService;
import com.rolandsall.walletservice.service.IWalletTransactionService;
import com.rolandsall.walletservice.enums.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WalletServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletServiceApplication.class, args);
    }

    @Bean
    @Autowired
    CommandLineRunner start(ICurrencyService currencyService, IWalletService walletService, IWalletTransactionService walletTransactionService){
        List<Currency> currency = getListOfCurrencies();
        Wallet initialWallet = getInitialWallet(currency.get(0));
        List<WalletTransaction> transaction = getTransactions(initialWallet);
        return args -> {
            currencyService.createCurrencies(currency);
            walletService.createWallet(initialWallet);
            walletTransactionService.createTransactions(transaction);

        };
    }

    private List<WalletTransaction> getTransactions(Wallet initialWallet) {
        WalletTransaction transaction_one =
                WalletTransaction.builder()
                        .wallet(initialWallet)
                        .amount(55.2)
                        .id(66)
                        .type(TransactionType.CREDIT)
                        .timeStamp(Long.valueOf(1412))
                        .build();

        WalletTransaction transaction_two =
                WalletTransaction.builder()
                        .wallet(initialWallet)
                        .amount(23.2)
                        .id(67)
                        .type(TransactionType.DEBIT)
                        .timeStamp(Long.valueOf(14152))
                        .build();

        return List.of(transaction_one,transaction_two);
    }

    private Wallet getInitialWallet(Currency currency) {
        return Wallet.builder()
                .id(1)
                .userId(55)
                .balance(500)
                .createdAt(Long.parseLong("10000"))
                .currency(currency)
                .build();

    }

    private List<Currency> getListOfCurrencies() {
        Currency usdCurrency = Currency
                .builder()
                .code("USD")
                .name("US Dollar")
                .salePrice(1.0242)
                .purchasePrice(1.0)
                .build();

        Currency euroCurrency = Currency
                .builder()
                .code("EUR")
                .name("EURO")
                .salePrice(0.89)
                .purchasePrice(0.9)
                .build();

        return List.of(usdCurrency,euroCurrency);
    }

}
