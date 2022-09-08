package Store;

import Domain.*;

public class USPizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {

        if(type.equals("Cheese"))
            return new USCheesePizza();
        else if(type.equals("Chicken"))
            return new USChickenPizza();
        return null;
    }
}
