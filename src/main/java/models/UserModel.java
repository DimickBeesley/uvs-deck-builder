package models;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    String firstname;
    String lastname;
    String username;
    String password;
    boolean ifExistedUser;
    List<String> borrowedBooks = new ArrayList<>();


    public UserModel(String firstname, String lastname, String username, String password, boolean ifExistedUser) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.ifExistedUser = ifExistedUser;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean isIfExistedUser() {
        return ifExistedUser;
    }

    public void setIfExistedUser(boolean ifExistedUser) {
        this.ifExistedUser = ifExistedUser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBorrowedBooks(String borrowedBook) {
        this.borrowedBooks.add(borrowedBook);
    }
    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }
}
