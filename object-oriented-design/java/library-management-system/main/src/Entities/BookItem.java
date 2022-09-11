package Entities;

import Enums.BookCategory;

import java.util.Date;
import java.util.List;

public class BookItem extends Book{
    private int barCode;
    private int numberOfCopies;

    private boolean isAvailable;
    private Rack rackLocation;

    public BookItem(String ISBN, String name, Date publicationDate, BookCategory bookCategory, List<Author> authorList, int barCode, int numberOfCopies, boolean isAvailable, Rack rackLocation) {
        super(ISBN, name, publicationDate, bookCategory, authorList);
        this.barCode = barCode;
        this.numberOfCopies = numberOfCopies;
        this.isAvailable = isAvailable;
        this.rackLocation = rackLocation;
    }

    public int getBarCode() {
        return barCode;
    }

        public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Rack getRackLocation() {
        return rackLocation;
    }

    public void setRackLocation(Rack rackLocation) {
        this.rackLocation = rackLocation;
    }
}
