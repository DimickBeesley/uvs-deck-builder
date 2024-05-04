
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="styles.css"%></style>

<html>
<head>
    <title>Created Decks</title>
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
        <a class="button" href="loginredirectpage.jsp">Back to User Home</a>
    </h2>
</div>
<body>
<h2 style="padding-left: 50px;">We have the following decks:</h2>
<c:forEach var="eachbuild" items="${user.buildernames}">
<h2 style="padding-left: 50px;">Deck name: ${eachbuild}</h2>
<h2 style="padding-left: 50px;">For each deck, it includes following cards</h2>
    <c:forEach var="eachbuilder" items="${user.differentdeckbuilders}">
<table style="padding-left: 50px;">
    <tr>
        <th>Name</th>
        <th>Set_Info</th>
        <th>Type</th>
        <th>Rarity</th>
        <th>Abilities</th>
        <th>Control</th>
        <th>Difficult</th>
    </tr>
    <c:forEach var="card" items="${eachbuilder}">
    <tr>
        <td>${card.getName()}</td>
        <td>${card.getSetinfo()}</td>
        <td>${card.getType()}</td>
        <td>${card.getRarity()}</td>
        <td>${card.getAbilities()}</td>
        <td>${card.getControl()}</td>
        <td>${card.getDifficult()}</td>
    </tr>
    </c:forEach>
</table>
        <p></p>
        <p></p>
        <p></p>
        <p></p>
    </c:forEach>
</c:forEach>
</body>
</html>