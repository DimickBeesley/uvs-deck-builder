<%@page import="java.sql.*"%>
<%@page import="jakarta.*"%>
<style><%@include file="styles.css"%></style>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Home</title>
</head>
<div class="header">
    <div>
        <a href="index.jsp">
            <h1 align="left" style="padding-left: 50px; font-family: 'Courier New',serif; font-size: 40px; color: #EFF0F3;">
                UVS-DECK-BUILDER
            </h1>
        </a>
    </div>
    <h2 style="padding-left: 50px;">Welcome ${user.getUsername()}
        <a class="button" href="LogoutServlet">Log Out</a>
    </h2>
</div>

<body>
<form name="loginRedirectHelp" method="post" action="LoginRedirectHelp">
    <p>${error}</p>
    <p>Please select a function</p>>>
    <select name="fn">
        <option value="scd">View your created deck(s)</option>
        <option value="cd">Create a new deck</option>
<%--        <option value="lo">Log out</option>--%>
    </select>
    <input type="submit" value="Submit">
</form>

</body>
</html>
