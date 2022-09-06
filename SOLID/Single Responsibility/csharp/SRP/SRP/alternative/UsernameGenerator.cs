namespace SRP.alternative;

public class UsernameGenerator
{
    public static void Generate(Person person)
    {
        Console.Write($"Your username is  {person.FirstName.Substring(0,1)} {person.LastName} ");
    }
}