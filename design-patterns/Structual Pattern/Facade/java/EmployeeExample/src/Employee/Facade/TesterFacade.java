
package Employee.Facade;

import Employee.Tester;
import Employee.HourReporter;
import Employee.PayCalculator.EmployeePayCalculator;
import Employee.PayCalculator.IPayCalculator;
import Employee.PayCalculator.PayTesterCalculator;

public class TesterFacade extends Facade{

    private final IPayCalculator payCalculator;

    private  final HourReporter hourReporter;

    private Tester tester;

    public TesterFacade(Tester tester) {
        this.tester = tester;
        payCalculator = new PayTesterCalculator();
        hourReporter = new HourReporter();
    }


    public int getSalary(int workingHours) {
        return payCalculator.getSalary(tester.getWorkingHours());
    }
    public void printReport(int workingHours){
        hourReporter.printReport(tester.getWorkingHours());
    }
}

