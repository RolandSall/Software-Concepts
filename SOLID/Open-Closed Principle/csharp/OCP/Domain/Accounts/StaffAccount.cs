namespace Domain.Accounts;

public class StaffAccount: IAccount
{
    public Employee Create(Person person)
    {
        return new Employee()
        {
            FirstName = person.FirstName,
            LastName = person.LastName,
            EmailAddress = $"{person.FirstName}.{person.LastName}.staff.@lau.edu"
        };
    }
}