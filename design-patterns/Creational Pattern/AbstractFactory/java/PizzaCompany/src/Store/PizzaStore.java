package Store;

import Domain.Pizza;
import Factory.SimplePizzaFactory;

public abstract class PizzaStore {


    public Pizza orderPizza(String type){
        Pizza pizza = null;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }

     abstract Pizza createPizza(String type);
}
