package Services;

import Entities.Book;
import Entities.Library;
import Entities.Staff;

public class LibraryService implements  ILibraryService{


    @Override
    public void addBook(Library library, Staff staff, Book book) {
        staff.addBook(library, book);
    }
}
