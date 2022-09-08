# Factories	

Factories fall under the categories of creational pattern since these involve creating objects. Lets take moment and discuss the `new` keyword.

> When you see `new` , think `concrete` 

Lets take the following example:

```java
Duck duck = new MallardDuck();
```

We want `duck` to be an interface to make the code flexible, but we have to create an instance of a concrete class.

When you have a set of related concrete classes often you are forced to have something similar to:

```java
Vehicle Vechile;

if("Electric")
    Vehicle = new ElectricVehicle();
else if("Hybrid")
     Vehicle = new HybridVehicle();

....
```

At runtime and based on conditions we determine the class being instantiated. Such a file later or on will needed to be examined again if a new type of `Vehicle` is added or deleted. Hence, maintenance and updates are more difficult and error-prone.

If you code is written to an interface, it will work with any new classes implementing that interface through polymorphism. However, when you have a code that makes uses of a lots of concrete classes, you are looking for trouble because that cade may have to be changed as new concrete classes are added. So yes in other words, your code will not be `closed for modification` .To extend it with new concrete types you will `have to reopen it` which is the main point of `OCP - Open Closed Principle` (Review the SOLID principles in this existent repo).

To illustrate the following, I will refer to the below image taken from this [book](https://www.amazon.com/Head-First-Design-Patterns-Brain-Friendly/dp/0596007124)

![image-20220908114929035](C:\Users\User\AppData\Roaming\Typora\typora-user-images\image-20220908114929035.png)



Looking at the image above, and following encapsulation principles the object creation should me moved from the `orderPizza()` method. This logic should be handled by a different Entity.... and Yes.. you guess it right! **A Factory**

``` java
public class SimplePizzaFactory {
    
    // this is the mehtod that the client will use to instantiate a new pizza object
    public Pizza createPizza(String type){
        Pizza pizza = null;
        
        if(type.equal("cheese"))
            pizza = new CheesePizza();
        else if (..){
            ...
        }
        
        return pizza;
    }
}
```



## Q & A

*Question 1:* What is the advantage of this? (we moved the same problem to a different class)

*Answer 1*: One thing to note that the `SimplePizzaFactory` may have many clients other than the `OrderPizza()` method. We could have `PizzaShopMenu` or any other clients that uses the same factory. Hence, this adjustment will provide a change (if needed) in only one place.

``` java
public class PizzaStroe {
    SimplePizzaFactory factory;
    
    public PizzaStore(SimplePizzaFactory factory){
        this.factory = factory;
    }
    
    public Pizza orderPizza(String type){
        Pizza pizza;
        
        // Notice that we have replaced the new operator
        // with a create method on the factory object
        // no moore concrete instantiation here it is moved to the factory.
        pizza = factory.createPizza(type);
        
        pizza.prepare();
        // other logic
        return pizza;
    }
       
    
}
```

# The Simple Factory

The simple factory ***is not*** actually a Design Pattern, but is is commonly used. 

#### Exercise

As a simple exercise try to create a simple car factory of the above example. Assume you a store to rent a car, and this store contain multiple car types Electric, Hybrid, Normal. 



# Factory Method

<Todo: add description, C# examples>

- <examples are already provided in java>

​	





# Abstract Factory 

<Todo: add description, C# examples> 

- <examples are already provided in java>





