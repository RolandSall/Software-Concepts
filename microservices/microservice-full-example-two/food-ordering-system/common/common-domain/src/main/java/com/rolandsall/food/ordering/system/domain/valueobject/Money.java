package com.rolandsall.food.ordering.system.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

// value object are immutable
public class Money {
    private final BigDecimal amount;

    public boolean isGreaterThanZero(){
        return this.amount !=null && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(Money money){
        return this.amount !=null && this.amount.compareTo(money.getAmount()) > 0;
    }

    // return a new instance -> immutable
    public Money add(Money money){
        return new Money(setScale(this.amount.add(money.getAmount())));
    }

    public Money subtract(Money money){
        return new Money(setScale(this.amount.subtract(money.getAmount())));
    }

    public Money multiply(int multiplier){
        return new Money(setScale(this.amount.multiply(new BigDecimal(multiplier))));
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private BigDecimal setScale(BigDecimal input){
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
