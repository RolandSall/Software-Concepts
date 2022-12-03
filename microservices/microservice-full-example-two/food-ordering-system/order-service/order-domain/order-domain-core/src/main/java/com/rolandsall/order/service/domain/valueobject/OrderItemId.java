package com.rolandsall.order.service.domain.valueobject;

import com.rolandsall.food.ordering.system.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
