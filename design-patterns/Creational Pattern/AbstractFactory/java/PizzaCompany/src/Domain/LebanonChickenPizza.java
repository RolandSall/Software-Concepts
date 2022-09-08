package Domain;

public class LebanonChickenPizza extends ChickenPizza{

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Extra Sauce");
    }
}
