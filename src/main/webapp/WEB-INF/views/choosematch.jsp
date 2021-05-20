<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <link rel="stylesheet" href="/css/styles2.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<!-- Image and text -->
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/">
        <img src="/docs/4.1/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
        HomePage
    </a>
</nav>
<form method="post">
<div>
    <label><b>Type of Match:</b></label>
    <select class="custom-select" name="matchType" id="matchType">
        <c:forEach var="matchtype" items="${matchtypelist}">
            <option value="${matchtype.getName()}">${matchtype.getName()}</option>
        </c:forEach>
    </select>
</div>
    <button type="submit">Select Match</button>
</form>
</body>
</html>