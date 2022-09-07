# Adapter Design Pattern



> Adapter is a design pattern that allows two incompatible interfaces to work together



This is encountered when a client expects a target interface. The adapter class allows the use of the available interface and the target interface.

TODO: <add-image>

Lets take the following example

```java
public interface Duck {
    public void quack();
    public void fly();
}


public class MallardDuck implements Duck {
    
    public void quack(){
        System.out.println("Quack");
    }
    
    public void fly (){
        System.out.println("Flying");
    }
}


public interface Turkey {
    public void gobble(); 
    public void fly(); // fly a short distance
}

public class WildTurkey implements Turkey {
        public void gobble(){
        System.out.println("Gobble");
    }
    
    public void fly (){
        System.out.println("Flying a short distance");
    }
}


public class TurkeyAdapter implements Duck {
    Turkey turkey;
    
    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }
    
        public void quack(){
        turkey.gobble();  // they do not quack instead they gobble
    }
    
    public void fly (){
        for(int i=0 ; i < 5 ; i++)
            turkey.fly(); // since they fly a short distance a cummaltive of short distance can be mapped to 						  // to a long sitance
    }
}


public class Test {
    public static void.... {
        
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        
        // calling adapter
        
        Duck turketAdapter = new  TurkeyAdapter(turkey);
    }
}
```



The general flow in the adapter interface is:

* The client makes a request to the adapter by calling a method on it using the target interface
* The adapter translates the request into one or more calls on the adaptee using the adaptee interface
* The client receives the results of the call and never knows there is an adapter doing the translation



* Pros - Conform with:
  * SRP principle: You can separate the interfaces or data conversion from the primary business logic of the program
  * OCP principle: you can introduce new adapters without modifying or breaking existing code 
* Cons:
  * The overall complexity increases while introducing new interfaces and classes. Sometimes it is easier to change the related the class rather then creating an interface to adapt it with the rest of code