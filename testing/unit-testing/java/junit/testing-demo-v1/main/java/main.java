import calculator.Calculator;
import calculator.SimpleCalculator;

public class main {
    public static void main(String[] args) {
        Calculator calculator = new SimpleCalculator();

        System.out.println(calculator.add(5,5));
    }
}
