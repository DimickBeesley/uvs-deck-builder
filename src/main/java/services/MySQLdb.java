package services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.CardModel;
import models.UserModel;

public class MySQLdb {
    String url = "jdbc:mysql://localhost:3306/deck_builder?useTimezone=true&serverTimezone=UTC";
    String username = "root";
    String password = "P@ssw0rd";
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
//        instance = new MySQLdb();
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

    public List<CardModel> fetchCards(List<String> parameters) throws SQLException {
        String set = parameters.get(0);
        String type = parameters.get(1);
        String rarity = parameters.get(2);
        String set_string;
        String type_string;
        String rarity_string;
        String temp_q;
        String q;
        Boolean flag = false;
        Boolean set_flag = true;
        if (set.equals("all")) {
            set_string = "";
        }else{
            set_string = "card.set like "+"'"+set+"%"+"'and";
            flag = true;
        }

        if (type.equals("all")) {
            type_string = "";
        }else{
            type_string = "card.type="+"'"+type+"'"+" and";
            flag = true;
            set_flag = false;
        }

        if (rarity.equals("all")) {
            rarity_string = "";
        }else{
            rarity_string = "card.rarity="+"'"+rarity+"'"+" and";
            flag = true;
            set_flag = false;
        }
        if (flag && !set_flag){
            temp_q = "select card.name,card.set,card.type,card.rarity,card.abilities,card.control,card.difficulty from card where " + set_string +" "+type_string+" "+rarity_string;
            q = temp_q.substring(0,temp_q.length()-4);
        } else if (flag && set_flag) {
            temp_q = "select card.name,card.set,card.type,card.rarity,card.abilities,card.control,card.difficulty from card where " + set_string +" "+type_string+" "+rarity_string;
            q = temp_q.substring(0,temp_q.length()-5);
        } else{
            q = "select card.name,card.set,card.type,card.rarity,card.abilities,card.control,card.difficulty from card";
        }

        List<CardModel> list = new ArrayList();
        PreparedStatement preparedStatement = this.connection.prepareStatement(q);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            String name_q = resultSet.getString("name");
            String set_q = resultSet.getString("set");
            String type_q = resultSet.getString("type");
            String rarity_q = resultSet.getString("rarity");
            String abilities_q = resultSet.getString("abilities");
            String control_q = resultSet.getString("control");
            String difficult_q = resultSet.getString("difficulty");
            CardModel card = new CardModel(name_q,set_q,type_q,rarity_q,abilities_q,control_q,difficult_q);
            list.add(card);
        }

        resultSet.close();
        preparedStatement.close();
        return list;
    }

    public CardModel fetchIndividualCard(String name) throws SQLException {

        String q = "select card.name,card.set,card.type,card.rarity,card.abilities,card.control,card.difficulty from card where card.name="+"'"+name+"'";
        String name_q = "";
        String set_q = "";
        String type_q = "";
        String rarity_q = "";
        String abilities_q = "";
        String control_q = "";
        String difficult_q = "";
//        String q = "select card.name,card.set,card.type,card.rarity,card.abilities,card.control,card.difficulty from card";
        PreparedStatement preparedStatement = this.connection.prepareStatement(q);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            name_q = resultSet.getString("name");
            set_q = resultSet.getString("set");
            type_q = resultSet.getString("type");
            rarity_q = resultSet.getString("rarity");
            abilities_q = resultSet.getString("abilities");
            control_q = resultSet.getString("control");
            difficult_q = resultSet.getString("difficulty");
        }
        CardModel card = new CardModel(name_q,set_q,type_q,rarity_q,abilities_q,control_q,difficult_q);

        return card;

//        for (int i=0;i<parameters.size();i++){
//
//
//        }
//        String set = parameters.get(0);
//        String type = parameters.get(1);
//        String rarity = parameters.get(2);
//        String set_string;
//        String type_string;
//        String rarity_string;
//        String temp_q;
//        String q;
//        Boolean flag = false;
//        Boolean set_flag = true;
//        if (set.equals("all")) {
//            set_string = "";
//        }else{
//            set_string = "card.set like "+"'"+set+"%"+"'and";
//            flag = true;
//        }
//
//        if (type.equals("all")) {
//            type_string = "";
//        }else{
//            type_string = "card.type="+"'"+type+"'"+" and";
//            flag = true;
//            set_flag = false;
//        }
//
//        if (rarity.equals("all")) {
//            rarity_string = "";
//        }else{
//            rarity_string = "card.rarity="+"'"+rarity+"'"+" and";
//            flag = true;
//            set_flag = false;
//        }
//
//
//
//        if (flag && !set_flag){
//            temp_q = "select card.name,card.set,card.type,card.rarity,card.abilities,card.control,card.difficulty from card where " + set_string +" "+type_string+" "+rarity_string;
//            q = temp_q.substring(0,temp_q.length()-4);
//        } else if (flag && set_flag) {
//            temp_q = "select card.name,card.set,card.type,card.rarity,card.abilities,card.control,card.difficulty from card where " + set_string +" "+type_string+" "+rarity_string;
//            q = temp_q.substring(0,temp_q.length()-5);
//        } else{
//            q = "select card.name,card.set,card.type,card.rarity,card.abilities,card.control,card.difficulty from card";
//        }
//
//        List<CardModel> list = new ArrayList();
//        PreparedStatement preparedStatement = this.connection.prepareStatement(q);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        while(resultSet.next()) {
//            String name_q = resultSet.getString("name");
//            String set_q = resultSet.getString("set");
//            String type_q = resultSet.getString("type");
//            String rarity_q = resultSet.getString("rarity");
//            String abilities_q = resultSet.getString("abilities");
//            String control_q = resultSet.getString("control");
//            String difficult_q = resultSet.getString("difficulty");
//            CardModel card = new CardModel(name_q,set_q,type_q,rarity_q,abilities_q,control_q,difficult_q);
//            list.add(card);
//        }
//
//        resultSet.close();
//        preparedStatement.close();
//        return list;
    }
//
//    public List<BookModel> fetchALL() throws SQLException {
//        String qGetBook = "select card.name, card.type, card.abilities \n" +
//                "from card\n" +
//                "where card.type = \"Action\"";
//        List<BookModel> list = new ArrayList();
//        PreparedStatement preparedStatement = this.connection.prepareStatement(qGetBook);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        while(resultSet.next()) {
//            String book_name = resultSet.getString("name");
//            String topic_name = resultSet.getString("type");
//            String author_name = resultSet.getString("abilities");
//            BookModel bookModel = new BookModel(book_name,topic_name,author_name);
//            list.add(bookModel);
//        }
//
//        resultSet.close();
//        preparedStatement.close();
//        return list;
//    }
//
//    public List<BookModel> fetchXML() throws SQLException {
//        String qGetBook = "select books.book_name, topics.topic_name, authors.author_name \n" +
//                "from books left join topics \n" +
//                "on books.topic_id = topics.topic_id \n" +
//                "join authors\n" +
//                "on books.author_id = authors.author_id\n" +
//                "where topics.topic_id = 1;";
//        List<BookModel> list = new ArrayList();
//        PreparedStatement preparedStatement = this.connection.prepareStatement(qGetBook);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        while(resultSet.next()) {
//            String book_name = resultSet.getString("book_name");
//            String topic_name = resultSet.getString("topic_name");
//            String author_name = resultSet.getString("author_name");
//            BookModel bookModel = new BookModel(book_name,topic_name,author_name);
//            list.add(bookModel);
//        }
//
//        resultSet.close();
//        preparedStatement.close();
//        return list;
//    }
//
//    public List<BookModel> fetchJSP() throws SQLException {
//        String qGetBook = "select books.book_name, topics.topic_name, authors.author_name \n" +
//                "from books left join topics \n" +
//                "on books.topic_id = topics.topic_id \n" +
//                "join authors\n" +
//                "on books.author_id = authors.author_id\n" +
//                "where topics.topic_id = 2;";
//        List<BookModel> list = new ArrayList();
//        PreparedStatement preparedStatement = this.connection.prepareStatement(qGetBook);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        while(resultSet.next()) {
//            String book_name = resultSet.getString("book_name");
//            String topic_name = resultSet.getString("topic_name");
//            String author_name = resultSet.getString("author_name");
//            BookModel bookModel = new BookModel(book_name,topic_name,author_name);
//            list.add(bookModel);
//        }
//
//        resultSet.close();
//        preparedStatement.close();
//        return list;
//    }
}
