package com.rolandsall24.cqrseventsourcingaxon.commands.product.commands;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;


@Getter
public class CreateProductCommand extends ProductBaseCommand<UUID> {

    private String name;
    private long serialNumber;

    public CreateProductCommand(UUID id, String name, long serialNumber) {
        super(id);
        this.name = name;
        this.serialNumber = serialNumber;
    }
}




