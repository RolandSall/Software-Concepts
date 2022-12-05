package com.rolandsall.order.service.domain.restaurant;

import com.rolandsall.order.service.domain.dto.message.RestaurantApprovalResponse;
import com.rolandsall.order.service.domain.ports.input.message.listener.restaurantapproval.IRestaurantApprovalResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class RestaurantApprovalResponseMessageListener implements IRestaurantApprovalResponseMessageListener {
    @Override
    public void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse) {

    }

    @Override
    public void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse) {

    }
}
