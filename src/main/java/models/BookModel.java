package models;

public class BookModel {
    String bookname;
    String topic;
    String author;

    public BookModel(String bookname, String topic, String author) {
        this.bookname = bookname;
        this.topic = topic;
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
