import Behaviours.Fly.SlowFly;
import Behaviours.Quack.IQuackBehavior;
import Behaviours.Quack.NormalQuack;

public class CityDuck extends Duck{


    public CityDuck() {
        setIQuackBehavior(new NormalQuack());
        setIFlyBehavior(new SlowFly());
    }



    @Override
    public void display() {
        System.out.println("I am a city duck");
    }
}
