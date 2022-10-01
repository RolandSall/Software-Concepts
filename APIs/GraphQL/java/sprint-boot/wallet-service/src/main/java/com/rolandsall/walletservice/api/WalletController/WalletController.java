package com.rolandsall.walletservice.api.WalletController;

import com.rolandsall.walletservice.domain.Wallet;
import com.rolandsall.walletservice.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WalletController {

    private IWalletService walletService;

    @Autowired
    public WalletController(IWalletService walletService) {
        this.walletService = walletService;
    }

    @QueryMapping()
    public List<Wallet> userWallets(){
        return walletService.findAll();
    }

    @QueryMapping()
    public Wallet walletById(@Argument int walletId){
        try {
            return walletService.findById(walletId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
