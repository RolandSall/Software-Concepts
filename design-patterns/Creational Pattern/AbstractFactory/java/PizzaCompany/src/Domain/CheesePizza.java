package Domain;

public class CheesePizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("Adding Extra Cheese");
    }

    @Override
    public void bake() {
        System.out.println("Bake Low Temperature for 30 min");

    }
}
