import Behaviours.Fly.IFlyBehavior;
import Behaviours.Quack.IQuackBehavior;

public abstract class Duck {

    private IQuackBehavior iQuackBehavior;
    private IFlyBehavior iFlyBehavior;

    public void performFly(){
        iFlyBehavior.fly();
    }

    public void performQuack(){
        iQuackBehavior.quack();
    }

    public void setIQuackBehavior(IQuackBehavior iQuackBehavior) {
        this.iQuackBehavior = iQuackBehavior;
    }

    public void setIFlyBehavior(IFlyBehavior iFlyBehavior) {
        this.iFlyBehavior = iFlyBehavior;
    }

    public abstract void display();
    public void swim(){
        System.out.println("Swim");
    }

}
