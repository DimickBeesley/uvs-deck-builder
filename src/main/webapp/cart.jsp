
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.UserModel" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your Cart:</h1>
<h2>${error}</h2>
<p>Book(s) in your cart now:</p>
<%
    if (request.getSession() != null) {
        if(session.getAttribute("user") != null) {
            UserModel user = (UserModel) session.getAttribute("user");
            List<String> borrowedBooks = user.getBorrowedBooks();
            for (String borrowedBook : borrowedBooks) {
                out.println("<p>"+borrowedBook+"</p>");
            }
        }
    }

%>

</body>
</html>

