package com.rolandsall24.cqrseventsourcingaxon.commands.product.events;

import com.rolandsall24.cqrseventsourcingaxon.commands.product.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateProductStatusEvent extends ProductBaseEvent<UUID>{

    private ProductStatus status;

    public UpdateProductStatusEvent(UUID id, ProductStatus status) {
        super(id);
        this.status = status;
    }
}
