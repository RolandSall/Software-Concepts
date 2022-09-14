package DTOs;

public class CreateUserDto {
    private String firstName;
    private String lastName;

    public CreateUserDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

     public String getLastName() {
        return lastName;
    }


}
