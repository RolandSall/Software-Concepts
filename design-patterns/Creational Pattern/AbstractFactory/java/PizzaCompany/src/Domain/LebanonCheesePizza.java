package Domain;

public class LebanonCheesePizza extends CheesePizza{

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Extra Fries Box");
    }
}
