import Entities.*;
import Enums.BookCategory;
import Services.ILibraryService;
import Services.LibraryService;

import java.util.Collections;
import java.util.Date;

public class main {
    public static void main(String[] args) {

        Book book = new BookItem(
                "ISBN001",
                "Book Name",
                new Date(),
                BookCategory.Drama,
                Collections.emptyList(),
                11344,
                5,
                true,
                new Rack(1,2)
        );

        Location location = new Location(1,2);
        Library library = new Library(location);

        Staff staff = new Librarian(101, "James", "Thomas","james.thomas@lib.com");
        library.addStaff(staff);

        ILibraryService libraryService = new LibraryService();

        libraryService.addBook(library,staff,book);


    }
}
