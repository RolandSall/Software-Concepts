namespace SRP.alternative;

public class PersonValidator
{
    public static bool Validate(Person person)
    {
        if (string.IsNullOrWhiteSpace(person.FirstName))
        {
            Console.Write("Not A Valid First Name! Try Again \n");
            return false;
        }
        
        if (string.IsNullOrWhiteSpace(person.LastName))
        {
            Console.Write("Not A Valid Last Name! Try Again \n");
            return false;
        }

        return true;
    }
}