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
<div>
    <a href="LogoutServlet">
        <p>Log out</p>
    </a>
</div>
<h1>Welcome, ${user.getUsername()}</h1>

<form name="loginRedirectHelp" method="post" action="LoginRedirectHelp">
    <p>${error}</p>
    <p>Please select a function</p>>>
    <select name="fn">
        <option value="scd">Show your created deck(s)</option>
        <option value="cd">Create a new deck</option>
<%--        <option value="lo">Log out</option>--%>
    </select>
    <input type="submit" value="Submit">
</form>

</body>
</html>
