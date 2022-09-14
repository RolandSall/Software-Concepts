package DTOs;

public class CreateSingerDto {
    private String firstName;
    private String lastName;

    public CreateSingerDto(String firstName, String lastName) {
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
