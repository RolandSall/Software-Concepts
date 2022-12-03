package com.rolandsall.order.service.domain.ports.output.repository;

import com.rolandsall.order.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
