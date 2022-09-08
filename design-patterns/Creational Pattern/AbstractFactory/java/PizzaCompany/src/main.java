import Store.LebanonPizzaStore;
import Store.PizzaStore;
import Store.USPizzaStore;

public class main {

    public static void main(String[] args) {

        System.out.println("Factory Method");
        System.out.println("*****************");

        PizzaStore pizzaStoreLeb = new LebanonPizzaStore();
        pizzaStoreLeb.orderPizza("Cheese");

        System.out.println("--------------------");


        PizzaStore pizzaStoreUs = new USPizzaStore();
        pizzaStoreUs.orderPizza("Cheese");
        System.out.println("*****************");
    }
}
