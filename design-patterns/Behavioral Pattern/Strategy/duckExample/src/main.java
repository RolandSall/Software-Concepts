import Behaviours.Quack.MuteQuack;

public class main {
    public static void main(String[] args) {

        Duck duck = new CityDuck();

        duck.performQuack();
        duck.performFly();

        duck.setIQuackBehavior(new MuteQuack());

        duck.performQuack();
    }
}
