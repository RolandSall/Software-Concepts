package Employee.PayCalculator;

public class PayDeveloperCalculator implements  IPayCalculator {

    @Override
    public int getSalary(int workingHours) {
        return workingHours * 40;
    }
}
