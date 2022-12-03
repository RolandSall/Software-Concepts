package com.rolandsall.order.service.domain.ports.output.message.publisher.restaurantapproval;

import com.rolandsall.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.rolandsall.order.service.domain.event.OrderCancelledEvent;
import com.rolandsall.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
