package com.rolandsall24.cqrseventsourcingaxon.commands.product.commands;

import com.rolandsall24.cqrseventsourcingaxon.commands.product.enums.ProductStatus;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateProductStatusCommand  extends ProductBaseCommand<UUID>{

    private ProductStatus status;

    public UpdateProductStatusCommand(UUID id, ProductStatus status) {
        super(id);
        this.status = status;
    }
}





