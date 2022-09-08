package Domain;

public class ChickenPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("Adding Extra Chicken");
    }

    @Override
    public void bake() {
    System.out.println("High Temperature for 1 hour");
    }
}
