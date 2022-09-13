import java.util.Objects;

public abstract class Beverage {
    private int beverageId;
    private int price;

    public Beverage(int beverageId, int price) {
        this.beverageId = beverageId;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beverage)) return false;
        Beverage beverage = (Beverage) o;
        return beverageId == beverage.beverageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beverageId);
    }
}
