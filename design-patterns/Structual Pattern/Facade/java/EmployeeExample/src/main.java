import Employee.Developer;
import Employee.Employee;
import Employee.Tester;

import java.util.List;

public class main {
    public static void main(String[] args) {

         Employee developer = new Developer("Robin", "Karaa", 35);
         Employee tester = new Tester("James", "Tomy", 23);
         Employee employee = new Tester("Harry", "Poter", 40);

         List<Employee> employeeList = List.of(developer,tester,employee);

        for (Employee emp: employeeList) {
          System.out.println("Salary: " + emp.getFacade().getSalary(employee.getWorkingHours()));
          emp.getFacade().printReport(employee.getWorkingHours());
        }


}
}
