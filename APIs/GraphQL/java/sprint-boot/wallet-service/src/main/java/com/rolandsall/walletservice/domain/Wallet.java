package com.rolandsall.walletservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
    @Id

    private int id;
    private double balance;
    private Long createdAt;
    private int userId;
    @ManyToOne
    private Currency currency;

    @OneToMany(mappedBy = "wallet")
    private List<WalletTransaction> walletTransactions;
}
