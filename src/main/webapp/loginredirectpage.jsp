<%@page import="java.sql.*"%>
<%@page import="jakarta.*"%>
<style><%@include file="styles.css"%></style>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Welcome, ${user.getUsername()}</h1>
<div>
    <a href="cart.jsp">
        <h1>Your Cart</h1>
    </a>
</div>
<div>
    <a href="LogoutServlet">
        <p>Log out</p>
    </a>
</div>

<form name="fetchbooks" method="post" action="FetchBooksServlet">
    <select name="selectitem">
        <option value="all">All</option>
        <option value="xml">XML</option>
        <option value="jsp">JSP</option>
    </select>
    <input type="hidden" name="whichpage" value="loginredirectpage.jsp">
    <input type="submit" value="Submit">

    <table>
        <tr>
            <th>Book name</th>
            <th>Topic</th>
            <th>Author</th>
            <th>Action</th>
        </tr>

        <c:forEach var="each_book" items="${list_of_books}">
            request.setAttribute("each_book", each_book);
            <tr>
                <td>${each_book.getBookname()}</td>
                <td>${each_book.getTopic()}</td>
                <td>${each_book.getAuthor()}</td>
                <td><a href="ReserveServlet?bookname=${each_book.getBookname()}">Reserve a copy</a></td>>
            </tr>
        </c:forEach>
    </table>

</form>

</body>
</html>
