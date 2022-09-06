package Employee.PayCalculator;

public class EmployeePayCalculator implements IPayCalculator {
    @Override
    public int getSalary(int workingHours) {
        return workingHours * 20;
    }
}
