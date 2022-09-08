package Domain;

public class USChickenPizza extends ChickenPizza{

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Extra Crust Added");
    }
}
