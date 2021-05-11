<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/styles1.css" type="text/css">
    <script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>
</head>
<body>
<a href="/resultsmatches" class="btn btn-success">
    Define Status
</a>
<form>
<table class="sortable" id="cssTable">
    <thead class="thead-dark">
    <tr>
        <th scope="col"> Picture </th>
        <th scope="col">WrestlerName</th>
        <th scope="col">Wins</th>
        <th scope="col">Losses</th>
        <th scope="col">Draws</th>
        <th scope="col">No Wins</th>
        <th scope="col">Streak</th>
        <th scope="col">Average</th>
        <th scope="col">Total</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="wrestler" items="${wrestlerData}">
    <tr>
        <td scope="col"> <img width="100" height="100" src="${pageContext.request.contextPath}/profilePic/${wrestler.getIdWrestler()}${wrestler.getFullName()}.png"> </td>
        <td scope="col">${wrestler.getWrestlerName()}</td>
        <td style="color: forestgreen" data-toggle="tooltip" title="Wins" scope="col">${wrestler.getWrestlingCard().getNumberVictories()}</td>
        <td style="color: red" data-toggle="tooltip" title="Losses" scope="col">${wrestler.getWrestlingCard().getNumberLosses()}</td>
        <td scope="col" data-toggle="tooltip" title="Draws">${wrestler.getWrestlingCard().getDraw()}</td>
        <td scope="col" data-toggle="tooltip" title="No Wins">${wrestler.getWrestlingCard().getNoWin()}</td>
        <td scope="col" data-toggle="tooltip" title="Streak">${wrestler.getWrestlingCard().getStreak()}</td>
        <td scope="col" data-toggle="tooltip" title="Average">${wrestler.getWrestlingCard().getTotalAverage()}%</td>
        <td scope="col" data-toggle="tooltip" title="Total Matches">${wrestler.getWrestlingCard().getTotalMatches()}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<button type="submit" class="float-right">
    Update
</button>
</form>
</body>
</html>