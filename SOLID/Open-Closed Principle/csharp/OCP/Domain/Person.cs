using Domain.Accounts;

namespace Domain;

public interface Person
{
    public string? FirstName { get; set; }
    public string? LastName { get; set; }
    public IAccount Account { get; set; }
}