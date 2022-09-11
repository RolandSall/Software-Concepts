package Entities;

public class Librarian  extends  Staff{

    public Librarian(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void Greet() {
        System.out.println("Hello I am a Librarian How Can I Help? ");
    }

 }
