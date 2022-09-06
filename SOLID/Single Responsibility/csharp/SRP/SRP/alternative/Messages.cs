namespace SRP.alternative;

public class Messages
{
    public static void WelcomeMessage()
    {
        Console.WriteLine("Welcome To This Journey");
    }

    public static void DisplayValidationError(string field)
    {
        Console.Write($"Not A Valid {field}! Try Again \n");
    }

    public static void EndApplication()
    {
        Console.ReadLine();
    }
}