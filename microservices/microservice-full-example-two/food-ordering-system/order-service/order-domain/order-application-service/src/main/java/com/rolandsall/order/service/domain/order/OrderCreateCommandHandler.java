package com.rolandsall.order.service.domain.order;

import com.rolandsall.order.service.domain.dto.create.CreateOrderCommand;
import com.rolandsall.order.service.domain.dto.create.CreateOrderResponse;
import com.rolandsall.order.service.domain.event.OrderCreatedEvent;
import com.rolandsall.order.service.domain.mapper.OrderDataMapper;
import com.rolandsall.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class OrderCreateCommandHandler {

    /***
     * It is one of the limitations of Springs AOP. Because the dao bean is in fact a proxy when it is created by spring,
     * it means that calling a method from within the same class will not call the advice (which is the transaction).
     * The same goes for any other pointcut
     */
    private final OrderCreateHelper orderCreateHelper;
    private final OrderDataMapper orderDataMapper;

    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreatOrderResponse(orderCreatedEvent.getOrder(), "Order Created Successfully");

    }


}
