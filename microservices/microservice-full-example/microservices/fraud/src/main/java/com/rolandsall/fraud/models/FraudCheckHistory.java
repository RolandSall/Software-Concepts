package com.rolandsall.fraud.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class FraudCheckHistory {

    @Id
    public UUID id;
    private UUID customerId;
    private boolean isFraud;
    private LocalDateTime createdAt;
}
