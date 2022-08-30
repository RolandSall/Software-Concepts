package fixed;

public class Male implements Human{

    private int height;
    private int weight;

    @Override
    public int calculateBMI() {
        return height/weight;
    }
}
