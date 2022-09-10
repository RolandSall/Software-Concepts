package Behaviours;


import Behaviours.Quack.IQuackBehavior;

/**
 * since the behaviour is already there
 * even not related duck subclasses can use it
 */
public class DuckCallSystem {

    private IQuackBehavior quackBehavior;

    public DuckCallSystem(IQuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void start(){
        System.out.println("Starting System Audio ....");
        quackBehavior.quack();
    }
}
