package Services;

import Entities.Book;
import Entities.Library;
import Entities.Staff;

public interface ILibraryService {
    void addBook(Library library, Staff staff, Book book);
}
