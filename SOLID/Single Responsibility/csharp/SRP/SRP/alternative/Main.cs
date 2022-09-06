namespace SRP.alternative;

public class MainNew
{
    static void Main(string[] args)
    {
        Messages.WelcomeMessage();
        Person user = PersonData.Capture();
        bool isValid = PersonValidator.Validate(user);

        if (!isValid)
        {
            Messages.EndApplication();
            return;
        }
        UsernameGenerator.Generate(user);
        Messages.EndApplication();
    }
}