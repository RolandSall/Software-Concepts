package com.rolandsall.order.service.domain.entity;

import com.rolandsall.food.ordering.system.domain.entity.BaseEntity;
import com.rolandsall.food.ordering.system.domain.valueobject.Money;
import com.rolandsall.food.ordering.system.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public Product(ProductId productId) {
        super.setId(productId);
    }



    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public void updateWithConfirmedNamedAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }
}
