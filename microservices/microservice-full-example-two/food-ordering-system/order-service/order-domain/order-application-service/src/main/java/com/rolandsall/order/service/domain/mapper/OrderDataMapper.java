package com.rolandsall.order.service.domain.mapper;

import com.rolandsall.food.ordering.system.domain.valueobject.CustomerId;
import com.rolandsall.food.ordering.system.domain.valueobject.Money;
import com.rolandsall.food.ordering.system.domain.valueobject.ProductId;
import com.rolandsall.food.ordering.system.domain.valueobject.RestaurantId;
import com.rolandsall.order.service.domain.dto.create.CreateOrderCommand;
import com.rolandsall.order.service.domain.dto.create.CreateOrderResponse;
import com.rolandsall.order.service.domain.dto.create.OrderAddress;
import com.rolandsall.order.service.domain.dto.track.TrackOrderResponse;
import com.rolandsall.order.service.domain.entity.Order;
import com.rolandsall.order.service.domain.entity.OrderItem;
import com.rolandsall.order.service.domain.entity.Product;
import com.rolandsall.order.service.domain.entity.Restaurant;
import com.rolandsall.order.service.domain.valueobject.StreetAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

   public Restaurant creteOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
        return Restaurant.Builder.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand
                        .getItems()
                        .stream()
                        .map(orderItem -> new Product(new ProductId(orderItem.getProductId())))
                        .collect(Collectors.toList()))
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand){
       return Order.Builder.builder()
               .customerId(new CustomerId(createOrderCommand.getCustomerId()))
               .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
               .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getOrderAddress()))
               .price(new Money(createOrderCommand.getPrice()))
               .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
               .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(List<com.rolandsall.order.service.domain.dto.create.OrderItem> orderItems) {
       return orderItems.stream()
               .map(orderItem -> OrderItem.Builder.builder()
                       .product(new Product(new ProductId(orderItem.getProductId())))
                       .price(new Money(orderItem.getPrice()))
                       .quantity(orderItem.getQuantity())
                       .subTotal(new Money(orderItem.getSubTotal()))
                       .build()).collect(Collectors.toList());
    }

    public CreateOrderResponse orderToCreatOrderResponse(Order order){
       return CreateOrderResponse.builder()
               .orderTrackingId(order.getTrackingId().getValue())
               .orderStatus(order.getOrderStatus())
               .build();
    }

    public TrackOrderResponse orderToTrackOrderResponse(Order order){
       return TrackOrderResponse.builder()
               .orderTrackingId(order.getTrackingId().getValue())
               .orderStatus(order.getOrderStatus())
               .failureMessages(order.getFailureMessages())
               .build();
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
       return new StreetAddress(
               UUID.randomUUID(),
               orderAddress.getStreet(),
               orderAddress.getPostalCode(),
               orderAddress.getCity()
       );
    }


}
