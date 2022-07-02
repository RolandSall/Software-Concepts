package com.rolandsall24.cqrseventsourcingaxon.product.commands.events;


import com.rolandsall24.cqrseventsourcingaxon.product.commands.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ProductCreatedEvent {
    private UUID productId;
    private String name;
    private long serialNumber;
    private ProductStatus productStatus;

    public ProductCreatedEvent(UUID productId, String name, long serialNumber) {
        this.productId = productId;
        this.name = name;
        this.serialNumber = serialNumber;
    }
}
