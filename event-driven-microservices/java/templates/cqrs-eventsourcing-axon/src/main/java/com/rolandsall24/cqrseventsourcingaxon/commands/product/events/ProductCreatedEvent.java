package com.rolandsall24.cqrseventsourcingaxon.commands.product.events;


import com.rolandsall24.cqrseventsourcingaxon.commands.product.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ProductCreatedEvent extends ProductBaseEvent<UUID> {
    private String name;
    private long serialNumber;
    private ProductStatus productStatus;

    public ProductCreatedEvent(UUID id, String name, long serialNumber, ProductStatus productStatus) {
        super(id);
        this.name = name;
        this.serialNumber = serialNumber;
        this.productStatus = productStatus;
    }
}
