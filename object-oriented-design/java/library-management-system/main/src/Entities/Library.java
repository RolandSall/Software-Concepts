package Entities;

import java.util.ArrayList;
import java.util.List;



public class Library {
    private Location location;
    private List<Staff> staffList;
    private List<Book> bookList;

    public Library(Location location) {
        this.location = location;
        staffList = new ArrayList<>();
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }


    public void addStaff(Staff staff){
        staffList.add(staff);
    }

    public void fireStaff(Staff staff){
        staffList.remove(staff);
    }




}
