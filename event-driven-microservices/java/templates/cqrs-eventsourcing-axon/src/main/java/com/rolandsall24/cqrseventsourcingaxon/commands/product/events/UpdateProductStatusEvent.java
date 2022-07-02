package com.rolandsall24.cqrseventsourcingaxon.commands.product.events;

import com.rolandsall24.cqrseventsourcingaxon.commands.product.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class UpdateProductStatusEvent {
    private UUID productId;
    private ProductStatus status;
}
