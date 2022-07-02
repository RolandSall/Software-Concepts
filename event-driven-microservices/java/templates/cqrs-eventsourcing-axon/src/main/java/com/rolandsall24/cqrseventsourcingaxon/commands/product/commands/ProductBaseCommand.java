package com.rolandsall24.cqrseventsourcingaxon.commands.product.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class ProductBaseCommand<T> {

    @Getter
    @TargetAggregateIdentifier
    private final T id;

    public ProductBaseCommand(T id) {
        this.id = id;
    }
}
