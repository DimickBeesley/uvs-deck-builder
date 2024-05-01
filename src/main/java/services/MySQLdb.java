package services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.BookModel;
import models.UserModel;

public class MySQLdb {
    String url = "jdbc:mysql://localhost:3306/library_catalog?useTimezone=true&serverTimezone=UTC";
    String username = "root";
    String password = "00001111";
    Connection connection = null;
    static MySQLdb instance = null;

    public MySQLdb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);


        } catch (ClassNotFoundException | SQLException var2) {
            Exception exception = var2;
            exception.printStackTrace();
        }

    }

    public static synchronized MySQLdb getInstance() {
        if (instance == null) {
            instance = new MySQLdb();
        }

        return instance;
    }

    public UserModel doLogin(String username, String password) throws SQLException {
        UserModel userModel = null;
        String qLogin = "SELECT fname, lname FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(qLogin);
        if (resultSet.next()) {
            String fname = resultSet.getString("fname");
            String lname = resultSet.getString("lname");
            userModel = new UserModel(fname,lname,username,password,true);
        }

        resultSet.close();
        statement.close();
        return userModel;
    }

    public UserModel doSignup(String firstname, String lastname,String username,String password) throws SQLException {
        UserModel userModel = null;
        Statement statement = this.connection.createStatement();
        ResultSet resultSet;
        String qr = "SELECT username FROM users WHERE username = '"+username+"'";
        resultSet = statement.executeQuery(qr);
        if(resultSet.next())
        {
            userModel = new UserModel(firstname, lastname, username, password,true);
        }
        else
        {

            String qSingup = "INSERT INTO users (fname, lname, username, password) values ('"+firstname+"', '"+lastname+"', '"+username+"', '"+password+"')";
            int isTrue;
            isTrue = statement.executeUpdate(qSingup);
            if (isTrue>0) {
                userModel = new UserModel(firstname, lastname, username, password,false);
            }
        }

        resultSet.close();
        statement.close();
        return userModel;

    }

    public List<BookModel> fetchALL() throws SQLException {
        String qGetBook = "select books.book_name, topics.topic_name, authors.author_name \n" +
                "from books left join topics \n" +
                "on books.topic_id = topics.topic_id \n" +
                "join authors\n" +
                "on books.author_id = authors.author_id";
        List<BookModel> list = new ArrayList();
        PreparedStatement preparedStatement = this.connection.prepareStatement(qGetBook);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            String book_name = resultSet.getString("book_name");
            String topic_name = resultSet.getString("topic_name");
            String author_name = resultSet.getString("author_name");
            BookModel bookModel = new BookModel(book_name,topic_name,author_name);
            list.add(bookModel);
        }

        resultSet.close();
        preparedStatement.close();
        return list;
    }

    public List<BookModel> fetchXML() throws SQLException {
        String qGetBook = "select books.book_name, topics.topic_name, authors.author_name \n" +
                "from books left join topics \n" +
                "on books.topic_id = topics.topic_id \n" +
                "join authors\n" +
                "on books.author_id = authors.author_id\n" +
                "where topics.topic_id = 1;";
        List<BookModel> list = new ArrayList();
        PreparedStatement preparedStatement = this.connection.prepareStatement(qGetBook);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            String book_name = resultSet.getString("book_name");
            String topic_name = resultSet.getString("topic_name");
            String author_name = resultSet.getString("author_name");
            BookModel bookModel = new BookModel(book_name,topic_name,author_name);
            list.add(bookModel);
        }

        resultSet.close();
        preparedStatement.close();
        return list;
    }

    public List<BookModel> fetchJSP() throws SQLException {
        String qGetBook = "select books.book_name, topics.topic_name, authors.author_name \n" +
                "from books left join topics \n" +
                "on books.topic_id = topics.topic_id \n" +
                "join authors\n" +
                "on books.author_id = authors.author_id\n" +
                "where topics.topic_id = 2;";
        List<BookModel> list = new ArrayList();
        PreparedStatement preparedStatement = this.connection.prepareStatement(qGetBook);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            String book_name = resultSet.getString("book_name");
            String topic_name = resultSet.getString("topic_name");
            String author_name = resultSet.getString("author_name");
            BookModel bookModel = new BookModel(book_name,topic_name,author_name);
            list.add(bookModel);
        }

        resultSet.close();
        preparedStatement.close();
        return list;
    }
}
