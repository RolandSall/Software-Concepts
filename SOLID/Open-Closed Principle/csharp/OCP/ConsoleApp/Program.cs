
using Domain;

public class Program
{
    static void Main(string[] args)
    {
        List<Person> applicants = new List<Person>
        {
            new Student() { FirstName = "Robin", LastName = "Karaa" , },
            new Staff() { FirstName = "Nick", LastName = "Young" },
            new Student() { FirstName = "James", LastName = "Thomas" }
        };

        List<Employee> students = new List<Employee>();
        //Account account = new Account();

        foreach (var person in applicants)
        {
            students.Add(person.Account.Create(person));
        }

        foreach (var student in students)
        {
            Console.WriteLine($"{student.FirstName } { student.LastName } { student.EmailAddress }");
        }

        Console.ReadLine();

    }
}