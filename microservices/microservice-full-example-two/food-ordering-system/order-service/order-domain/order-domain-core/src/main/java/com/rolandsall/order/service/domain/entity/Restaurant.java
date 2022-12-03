package com.rolandsall.order.service.domain.entity;

import com.rolandsall.food.ordering.system.domain.entity.AggregateRoot;
import com.rolandsall.food.ordering.system.domain.valueobject.RestaurantId;

import java.util.List;

public class Restaurant extends AggregateRoot<RestaurantId> {
    private final List<Product> products;
    private boolean active;



    public Restaurant(List<Product> products, boolean active) {
        this.products = products;
        this.active = active;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isActive() {
        return active;
    }

    private Restaurant(Builder builder) {
        super.setId(builder.restaurantId);
        products = builder.products;
        active = builder.active;
    }

    public static final class Builder {
        private RestaurantId restaurantId;
        private List<Product> products;
        private boolean active;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder restaurantId(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
