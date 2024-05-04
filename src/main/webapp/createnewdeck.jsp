<%@ page import="models.CardModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form name="createnewdeck" method="post" action="CreateNewDeckServlet">
  <p>Please input your new deck name</p>
  <input type="text" name="newdeckname"  />
  <p>If you finish the deck building, pleaase click the Done button"</p>
  <input type="submit" name="done" value="Done">

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
  <input type="hidden" name="whichpage" value="createnewdeck.jsp">
  <input type="submit" name="query" value="Query">



  <table>
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
      <td><a href="CreateNewDeckServlet?cardname=${card.getName()}">Add it to the current deck</a></td>
      <p>${error}</p>
    </tr>
    </c:forEach>

</form>

</body>
</html>