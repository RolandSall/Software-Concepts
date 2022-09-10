package Behaviours.Quack;

public class NormalQuack implements IQuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
