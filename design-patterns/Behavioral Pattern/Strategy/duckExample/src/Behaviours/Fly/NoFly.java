package Behaviours.Fly;

public class NoFly implements IFlyBehavior {

    @Override
    public void fly() {
        System.out.println("I Can't even Fly");
    }
}
