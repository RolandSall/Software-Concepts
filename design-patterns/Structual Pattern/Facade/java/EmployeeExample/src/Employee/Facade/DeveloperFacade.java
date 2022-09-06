
package Employee.Facade;

import Employee.Developer;
import Employee.PayCalculator.IPayCalculator;
import Employee.HourReporter;
import Employee.PayCalculator.PayDeveloperCalculator;

public class DeveloperFacade extends Facade{

    private final IPayCalculator payCalculator;

    private final HourReporter hourReporter;

    private Developer developer;

    public DeveloperFacade(Developer developer) {
        this.developer = developer;
        payCalculator = new PayDeveloperCalculator();
        hourReporter = new HourReporter();
    }


    public int getSalary(int workingHours) {
        return payCalculator.getSalary(developer.getWorkingHours());
    }
    public void printReport(int workingHours){
        hourReporter.printReport(developer.getWorkingHours());
    }
}

