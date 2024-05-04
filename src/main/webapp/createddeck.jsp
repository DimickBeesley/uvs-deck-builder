
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="loginredirectpage.jsp">
        <p>Back to main menu</p>
    </a>
</div>
<h1>We have the following decks:</h1>
<c:forEach var="eachbuild" items="${user.buildernames}">
<h1>Deck name: ${eachbuild}</h1>
</c:forEach>
<h1>For each deck, it includes following cards</h1>
    <c:forEach var="eachbuilder" items="${user.differentdeckbuilders}">
<table>
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
</body>
</html>