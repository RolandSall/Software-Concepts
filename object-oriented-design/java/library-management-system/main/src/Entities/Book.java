package Entities;

import Enums.BookCategory;

import java.util.Date;
import java.util.List;

public abstract class Book {
     String ISBN;
     String name;
     Date publicationDate;
     BookCategory bookCategory;
     List<Author> authorList;

    public Book(String ISBN, String name, Date publicationDate, BookCategory bookCategory, List<Author> authorList) {
        this.ISBN = ISBN;
        this.name = name;
        this.publicationDate = publicationDate;
        this.bookCategory = bookCategory;
        this.authorList = authorList;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
