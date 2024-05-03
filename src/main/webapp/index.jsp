
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@page import="jakarta.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UVS-DECK-BUILDER</title>
</head>
<body>
<div>
    <a href="index.jsp">
        <h1>UVS-DECK-BUILDER</h1>
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

<form name="fetchCardsInformation" method="post" action="FetchCardsInformation">
    <p>Please select card set</p>>>
    <select name="selectset">
        <option value="all">All</option>
        <option value="set 8">Set-8</option>
        <option value="set 9">Set-9</option>
        <option value="set 10">Set-10</option>
        <option value="set 11">Set-11</option>
        <option value="set 12">Set-12</option>
        <option value="set 14">Set-14</option>
    </select>
    <p>Please select card type</p>>>
    <select name="selecttype">
        <option value="all">All</option>
        <option value="Character">Character</option>
        <option value="Action">Action</option>
        <option value="Asset">Asset</option>
        <option value="Attack">Attack</option>
        <option value="Foundation">Foundation</option>
    </select>
    <p>Please select card rarity</p>>>
    <select name="selectrarity">
        <option value="all">All</option>
        <option value="Common">Common</option>
        <option value="Rare">Rare</option>
        <option value="Ultra rare">UltraRare</option>
        <option value="Unco">Unco</option>
    </select>
    <input type="hidden" name="whichpage" value="index.jsp">
    <input type="submit" value="Submit">

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

        <c:forEach var="card" items="${cards}">
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

</form>

</body>
</html>