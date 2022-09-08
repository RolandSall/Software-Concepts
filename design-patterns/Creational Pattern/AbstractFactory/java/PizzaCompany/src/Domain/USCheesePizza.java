package Domain;

public class USCheesePizza extends CheesePizza{

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Extra Crust Added");
    }


}
