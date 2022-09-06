package Employee.Facade;

import Employee.HourReporter;
import Employee.PayCalculator.IPayCalculator;

public abstract class Facade  {

    public abstract int getSalary(int workingHours);
    public abstract void printReport(int workingHours);
}
