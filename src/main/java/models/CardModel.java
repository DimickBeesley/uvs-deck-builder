package models;

public class CardModel {
    String name;
    String setinfo;
    String type;
    String rarity;
    String abilities;
    String control;
    String difficult;
    String deckname;

    public CardModel() {
        this.name = "";
        this.setinfo = "";
        this.type = "";
        this.rarity = "";
        this.abilities = "";
        this.control = "";
        this.difficult = "";
        this.deckname = "";
    }

    public CardModel(String name, String setinfo, String type, String rarity, String abilities, String control, String difficult) {
        this.name = name;
        this.setinfo = setinfo;
        this.type = type;
        this.rarity = rarity;
        this.abilities = abilities;
        this.control = control;
        this.difficult = difficult;
    }

    public CardModel(String name, String setinfo, String type, String rarity, String abilities, String control, String difficult,String deckname) {
        this.name = name;
        this.setinfo = setinfo;
        this.type = type;
        this.rarity = rarity;
        this.abilities = abilities;
        this.control = control;
        this.difficult = difficult;
        this.deckname = deckname;
    }

    public String getDeckname() {
        return deckname;
    }

    public void setDeckname(String deckname) {
        this.deckname = deckname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSetinfo() {
        return setinfo;
    }

    public void setSetinfo(String setinfo) {
        this.setinfo = setinfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }
}


