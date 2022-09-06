using Domain.Accounts;

namespace Domain;

public class Student: Person
{
    public string? FirstName { get; set; }
    public string? LastName { get; set; }

    public IAccount Account { get; set; }= new StudentAccount();
}