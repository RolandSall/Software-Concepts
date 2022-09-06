package Employee;

import Employee.Facade.DeveloperFacade;
import Employee.Facade.Facade;

public class Developer extends Employee {


    private DeveloperFacade facade;
    public Developer(String firstName, String lastName, int workingHours) {

        super(firstName, lastName, workingHours);
        facade = new DeveloperFacade(this);
    }

    @Override
    public DeveloperFacade getFacade() {
        return facade;
    }
}