package fixed;

public class Female implements Human{


    private int height;
    private int weight;


    @Override
    public int calculateBMI() {
        return height-5/weight;
    }
}
