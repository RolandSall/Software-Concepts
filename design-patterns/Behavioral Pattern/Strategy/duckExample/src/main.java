import Behaviours.DuckCallSystem;
import Behaviours.Quack.MuteQuack;
import Behaviours.Quack.NormalQuack;

public class main {
    public static void main(String[] args) {

        Duck duck = new CityDuck();

        duck.performQuack();
        duck.performFly();

        duck.setIQuackBehavior(new MuteQuack());

        duck.performQuack();


        DuckCallSystem duckCallSystem = new DuckCallSystem(new NormalQuack());

        // notice also the abstraction
        duckCallSystem.start();
    }
}
