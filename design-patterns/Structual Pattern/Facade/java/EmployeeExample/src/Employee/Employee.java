package Employee;

import Employee.Facade.EmployeeFacade;
import Employee.Facade.Facade;

public class Employee {
    private String firstName;
    private String lastName;
    private int workingHours;

    private Facade facade;

    public Employee(String firstName, String lastName, int workingHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workingHours = workingHours;
        facade = new EmployeeFacade(this);
    }

    public Facade getFacade() {
        return facade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
}
