package com.rolandsall.order.service.domain.order;

import com.rolandsall.order.service.domain.dto.track.TrackOrderQuery;
import com.rolandsall.order.service.domain.dto.track.TrackOrderResponse;
import com.rolandsall.order.service.domain.entity.Order;
import com.rolandsall.order.service.domain.exception.OrderNotFoundException;
import com.rolandsall.order.service.domain.mapper.OrderDataMapper;
import com.rolandsall.order.service.domain.ports.output.repository.OrderRepository;
import com.rolandsall.order.service.domain.valueobject.TrackingId;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class OrderTrackCommandHandler {

    private final OrderDataMapper orderDataMapper;
    private final OrderRepository orderRepository;


    @Transactional(readOnly = true)
    TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery){
        Optional<Order> orderResult = orderRepository.findByTrackingId(new TrackingId(trackOrderQuery.getOrderTrackingId()));
        if(orderResult.isEmpty()){
            log.warn("Could not find order with tracking id: {}", trackOrderQuery.getOrderTrackingId());
            throw new OrderNotFoundException("Could not find order with tracking id: {} " + trackOrderQuery.getOrderTrackingId());
        }
        return orderDataMapper.orderToTrackOrderResponse(orderResult.get());
    }
}
