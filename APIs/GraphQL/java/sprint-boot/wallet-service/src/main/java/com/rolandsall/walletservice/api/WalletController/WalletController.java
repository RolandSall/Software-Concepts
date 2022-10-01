package com.rolandsall.walletservice.api.WalletController;

import com.rolandsall.walletservice.domain.Currency;
import com.rolandsall.walletservice.domain.Wallet;
import com.rolandsall.walletservice.dto.AddWalletRequestDTO;
import com.rolandsall.walletservice.repositories.ICurrencyRepository;
import com.rolandsall.walletservice.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Random;

@Controller
public class WalletController {

    private IWalletService walletService;
    private ICurrencyRepository currencyRepository;
    private Random rnd;

    @Autowired
    public WalletController(IWalletService walletService, ICurrencyRepository currencyRepository) {
        this.walletService = walletService;
        this.currencyRepository = currencyRepository;
        rnd = new Random();
    }

    @QueryMapping()
    public List<Wallet> userWallets() {
        return walletService.findAll();
    }

    @QueryMapping()
    public Wallet walletById(@Argument int walletId) {
        try {
            return walletService.findById(walletId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @MutationMapping
    public Wallet addWallet(@Argument AddWalletRequestDTO walletDto) {
        Currency currency = currencyRepository.findById(walletDto.getCurrencyCode()).orElseThrow(() -> new RuntimeException("Wallet Not Found"));

        Wallet wallet = Wallet.builder()
                .balance(walletDto.getBalance())
                .id(rnd.nextInt(1000))
                .createdAt(Long.valueOf(1000))
                .currency(currency)
                .userId(1)
                .build();

        return walletService.addWallet(wallet);
    }



}
