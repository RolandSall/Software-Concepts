package com.rolandsall.order.service.domain.valueobject;

import com.rolandsall.food.ordering.system.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {

    public TrackingId(UUID value) {
        super(value);
    }
}
