package com.rolandsall24.cqrseventsourcingaxon.commands.product.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class ProductBaseEvent<T> {

    @Getter
    private final T id;
}
