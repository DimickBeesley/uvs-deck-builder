
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@page import="jakarta.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Library</title>
</head>
<body>
<div>
    <a href="index.jsp">
        <h1>Library Catalog</h1>
    </a>
</div>

<div>
    <a href="singuppage.jsp">
        <p>Sign up</p>
    </a>
</div>

<div>
    <a href="loginpage.jsp">
        <p>Login</p>
    </a>
</div>

<form name="fetchbooks" method="post" action="FetchBooksServlet">
    <select name="selectitem">
        <option value="all">All</option>
        <option value="xml">XML</option>
        <option value="jsp">JSP</option>
    </select>
    <input type="hidden" name="whichpage" value="index.jsp">
    <input type="submit" value="Submit">

    <table>
        <tr>
            <th>Book name</th>
            <th>Topic</th>
            <th>Author</th>
        </tr>

        <c:forEach var="each_book" items="${list_of_books}">
            <tr>
                <td>${each_book.getBookname()}</td>
                <td>${each_book.getTopic()}</td>
                <td>${each_book.getAuthor()}</td>
            </tr>
        </c:forEach>
    </table>

</form>

</body>
</html>