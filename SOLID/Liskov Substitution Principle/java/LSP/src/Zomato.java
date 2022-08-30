public class Zomato extends FoodOrderApplication{


    @Override
    public void checkDriverLocation() {

    }

    @Override
    public void PayDirectly() {

    }


    // violates LSP since zomato does not support the following
    @Override
    public void askForFoodRecommendation() {

    }
}
