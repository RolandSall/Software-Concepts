public class Whip extends AddOnDecorator{
    Beverages beverages;

    public Whip(Beverages beverages) {
        this.beverages = beverages;
    }

    @Override
    public String getDescription() {
        return beverages.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverages.cost() + 0.10;
    }
}
