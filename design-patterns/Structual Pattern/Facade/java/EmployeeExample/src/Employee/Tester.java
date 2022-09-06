package Employee;

import Employee.Facade.DeveloperFacade;
import Employee.Facade.Facade;
import Employee.Facade.TesterFacade;

public class Tester extends Employee{

    private TesterFacade facade;
    public Tester(String firstName, String lastName, int workingHours) {
        super(firstName, lastName, workingHours);
        facade = new TesterFacade(this);
    }

    @Override
    public TesterFacade getFacade() {
        return facade;
    }
}
