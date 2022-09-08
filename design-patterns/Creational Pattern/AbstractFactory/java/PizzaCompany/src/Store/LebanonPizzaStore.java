package Store;

import Domain.LebanonCheesePizza;
import Domain.LebanonChickenPizza;
import Domain.Pizza;

public class LebanonPizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {

        if(type.equals("Cheese"))
            return new LebanonCheesePizza();
        else if(type.equals("Chicken"))
            return new LebanonChickenPizza();
        return null;
    }
}
