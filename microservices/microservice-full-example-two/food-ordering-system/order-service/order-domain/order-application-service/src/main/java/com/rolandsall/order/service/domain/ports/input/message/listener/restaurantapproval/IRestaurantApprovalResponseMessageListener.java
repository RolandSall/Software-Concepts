package com.rolandsall.order.service.domain.ports.input.message.listener.restaurantapproval;

import com.rolandsall.order.service.domain.dto.message.RestaurantApprovalResponse;

public interface IRestaurantApprovalResponseMessageListener {

    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);

    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);

}
