package Factory;

import Domain.CheesePizza;
import Domain.ChickenPizza;
import Domain.Pizza;

public class SimplePizzaFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;

        if(type.equals("Cheese"))
            pizza = new CheesePizza();
        else if (type.equals("Chicken"))
            pizza = new ChickenPizza();

        return pizza;
    }
}
