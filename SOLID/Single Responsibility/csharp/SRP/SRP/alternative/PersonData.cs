namespace SRP.alternative;

public class PersonData
{
    public static Person Capture()
    {
        Person result = new Person();
        
        Console.Write("Enter Your First Name \n");
        result.FirstName = Console.ReadLine();
        
        Console.Write("Enter Your Last Name \n");
        result.LastName = Console.ReadLine();

        return result;
    }
}