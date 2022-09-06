
using System.Security.Cryptography.X509Certificates;
using SRP;
using SRP.alternative;

class Program
{
    static void MainOld(string[] args)
    {
        Console.WriteLine("Welcome To This Journey");

        Person user = new Person();
        
        Console.Write("Enter Your First Name \n");
        user.FirstName = Console.ReadLine();
        
        Console.Write("Enter Your Last Name \n");
        user.LastName = Console.ReadLine();

        if (string.IsNullOrWhiteSpace(user.FirstName))
        {
            Messages.DisplayValidationError("First Name");
            Console.ReadLine();
            return;
        }
        
        if (string.IsNullOrWhiteSpace(user.LastName))
        {
            Messages.DisplayValidationError("Last Name");
            Console.ReadLine();
            return;
        }
        
        Console.Write($"Your username is  {user.FirstName.Substring(0,1)} {user.LastName} ");
        Console.ReadLine();
    }
}


