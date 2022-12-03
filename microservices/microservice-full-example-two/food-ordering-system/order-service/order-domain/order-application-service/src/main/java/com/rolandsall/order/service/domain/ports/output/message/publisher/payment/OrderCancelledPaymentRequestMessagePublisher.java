package com.rolandsall.order.service.domain.ports.output.message.publisher.payment;

import com.rolandsall.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.rolandsall.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
