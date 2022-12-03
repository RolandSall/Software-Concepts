package com.rolandsall.order.service.domain.exception;

import com.rolandsall.food.ordering.system.domain.exception.DomainException;

public class OrderDomainException extends DomainException {

    public OrderDomainException(String message) {
        super(message);
    }

    public OrderDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
