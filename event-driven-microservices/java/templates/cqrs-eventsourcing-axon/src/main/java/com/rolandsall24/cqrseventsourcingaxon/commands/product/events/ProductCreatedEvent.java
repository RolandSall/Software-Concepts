package com.rolandsall24.cqrseventsourcingaxon.commands.product.events;


import com.rolandsall24.cqrseventsourcingaxon.commands.product.enums.ProductStatus;
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

}
