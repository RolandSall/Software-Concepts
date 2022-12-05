package com.rolandsall.order.service.domain.order;

import com.rolandsall.order.service.domain.OrderDomainService;
import com.rolandsall.order.service.domain.dto.create.CreateOrderCommand;
import com.rolandsall.order.service.domain.dto.create.CreateOrderResponse;
import com.rolandsall.order.service.domain.entity.Customer;
import com.rolandsall.order.service.domain.entity.Order;
import com.rolandsall.order.service.domain.entity.Restaurant;
import com.rolandsall.order.service.domain.event.OrderCreatedEvent;
import com.rolandsall.order.service.domain.exception.OrderDomainException;
import com.rolandsall.order.service.domain.mapper.OrderDataMapper;
import com.rolandsall.order.service.domain.ports.output.repository.CustomerRepository;
import com.rolandsall.order.service.domain.ports.output.repository.OrderRepository;
import com.rolandsall.order.service.domain.ports.output.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@AllArgsConstructor
public class OrderCreateCommandHandler {

    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderDataMapper orderDataMapper;


    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Restaurant restaurant = checkRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
        Order orderResult = saveOrder(order);
        log.info("Order is created with id: {}", orderResult.getId().getValue());
        return orderDataMapper.orderToCreatOrderResponse(order);

    }

    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        Restaurant restaurant = orderDataMapper.creteOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findRestaurantInformation(restaurant);
        return optionalRestaurant.orElseThrow(() -> {
            log.warn("Could not find restaurant with customer id: {}", createOrderCommand.getRestaurantId());
            throw new OrderDomainException("Could not find restaurant with customer id: " + createOrderCommand.getRestaurantId());
        });

    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            log.warn("Could not find customer with customer id: {}", customerId);
            throw new OrderDomainException("Could not find customer with customer id: " + customer);
        }
    }

    private Order saveOrder(Order order) {
        Order orderResult = orderRepository.save(order);
        if (orderResult == null) {
            log.error("Could not save order!");
            throw new OrderDomainException("Could not save order!");
        }
        log.info("Order is saved with id: {}", orderResult.getId().getValue());
        return orderResult;
    }
}
