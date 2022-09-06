package Employee.PayCalculator;

public class PayTesterCalculator implements  IPayCalculator{

    @Override
    public int getSalary(int workingHours) {
        return workingHours * 35;
    }
}
