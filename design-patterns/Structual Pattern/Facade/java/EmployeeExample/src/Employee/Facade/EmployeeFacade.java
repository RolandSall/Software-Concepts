package Employee.Facade;

import Employee.Employee;
import Employee.HourReporter;
import Employee.PayCalculator.EmployeePayCalculator;
import Employee.PayCalculator.IPayCalculator;

public class EmployeeFacade extends Facade {

    private final IPayCalculator payCalculator;

    private  final HourReporter hourReporter;

    private Employee employee;

    public EmployeeFacade(Employee employee) {
        this.employee = employee;
        payCalculator = new EmployeePayCalculator();
        hourReporter = new HourReporter();
    }


    public int getSalary(int workingHours) {
        return payCalculator.getSalary(employee.getWorkingHours());
    }
    public void printReport(int workingHours){
        hourReporter.printReport(employee.getWorkingHours());
    }
}
