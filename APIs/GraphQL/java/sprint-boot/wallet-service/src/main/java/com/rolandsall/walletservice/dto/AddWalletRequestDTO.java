package com.rolandsall.walletservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddWalletRequestDTO {
    private Double balance;
    private String currencyCode;
}