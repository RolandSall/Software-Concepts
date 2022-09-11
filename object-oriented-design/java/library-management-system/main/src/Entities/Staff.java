package Entities;

public abstract class Staff  {

     int id;
     String firstName;
     String lastName;
     String email;

     public Staff(int id, String firstName, String lastName, String email) {
          this.id = id;
          this.firstName = firstName;
          this.lastName = lastName;
          this.email = email;
     }

     public abstract void Greet();

     public void addBook(Library library, Book book) {
          library.getBookList().add(book);
     }
}
