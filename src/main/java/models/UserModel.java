package models;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    String firstname;
    String lastname;
    String username;
    String password;
    boolean ifExistedUser;
    ArrayList<CardModel> decks = new ArrayList<>();
    ArrayList<String> curnamelist = null;
    ArrayList<ArrayList<CardModel>> differentdeckbuilders = null;
    ArrayList<String> buildernames = null;



    public UserModel(String firstname, String lastname, String username, String password, boolean ifExistedUser) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.ifExistedUser = ifExistedUser;
        this.decks = new ArrayList<CardModel>();
        this.curnamelist = new ArrayList<String>();
        this.differentdeckbuilders = new ArrayList<ArrayList<CardModel>>();
        this.buildernames = new ArrayList<String>();
    }

    public String getDeckname() {
        return lastname;
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

    public void addDeck(CardModel borrowedBook) {
        this.decks.add(borrowedBook);
    }
    public void resetDeck() {
        this.decks = new ArrayList<CardModel>();
    }
    public ArrayList<CardModel> getDecks() {
        return this.decks;
    }

    public ArrayList<String> getCurnamelist() {
        return curnamelist;
    }

    public void addCurnamelist(String par) {
        this.curnamelist.add(par);
    }

    public void resetCurnamelist() {
        this.curnamelist = new ArrayList<String>();
    }

    public ArrayList<ArrayList<CardModel>> getDifferentdeckbuilders() {
        return differentdeckbuilders;
    }

    public void addDifferentdeckbuilders(ArrayList<CardModel> paramet) {
        differentdeckbuilders.add(paramet);
    }

    public ArrayList<String> getBuildernames() {
        return buildernames;
    }

    public void addBuildernames(String par) {
        this.buildernames.add(par);
    }
}
