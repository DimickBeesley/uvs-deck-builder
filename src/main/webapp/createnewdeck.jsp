<%@ page import="models.CardModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="styles.css"%></style>

<html>
<head>
    <title>Deck Builder</title>
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

<form name="createnewdeck" method="post" action="CreateNewDeckServlet">
  <p>Please input your new deck name</p>
  <input type="text" name="newdeckname"  />
  <p>Once you're satisfied with the deck, give your deck a name and click "Done"</p>
  <input type="submit" name="done" value="Done">

  <p>Filter by card set</p>>>
  <select name="selectset">
    <option value="all">All</option>
    <option value="set 8">Set-8</option>
    <option value="set 9">Set-9</option>
    <option value="set 10">Set-10</option>
    <option value="set 11">Set-11</option>
    <option value="set 12">Set-12</option>
    <option value="set 14">Set-14</option>
  </select>
  <p>Filter by card type</p>>>
  <select name="selecttype">
    <option value="all">All</option>
    <option value="Character">Character</option>
    <option value="Action">Action</option>
    <option value="Asset">Asset</option>
    <option value="Attack">Attack</option>
    <option value="Foundation">Foundation</option>
  </select>
  <p>Filter by card rarity</p>>>
  <select name="selectrarity">
    <option value="all">All</option>
    <option value="Common">Common</option>
    <option value="Rare">Rare</option>
    <option value="Ultra rare">UltraRare</option>
    <option value="Unco">Unco</option>
  </select>
  <input type="hidden" name="whichpage" value="createnewdeck.jsp">
  <input type="submit" name="query" value="Query">



  <table cellpadding="5">
    <tr>
      <th>Name</th>
      <th>Set_Info</th>
      <th>Type</th>
      <th>Rarity</th>
      <th>Abilities</th>
      <th>Control</th>
      <th>Difficult</th>
      <th>Action</th>
      <th>Comment</th>
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
      <td><a href="CreateNewDeckServlet?cardname=${card.getName()}">Add to deck</a></td>
      <p>${error}</p>
    </tr>
    </c:forEach>

</form>

</body>
</html>
