using Domain.Accounts;

namespace Domain;

public class Staff: Person
{
    public string? FirstName { get; set; }
    public string? LastName { get; set; }
    public IAccount Account { get; set; }= new StaffAccount();
}