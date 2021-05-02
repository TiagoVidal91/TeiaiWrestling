<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
<div class="custom-control custom-radio">
    <input type="radio" id="win" name="typeMatch" value="0" class="custom-control-input" checked>
    <label class="custom-control-label" for="win">Won</label>
</div>
<div class="custom-control custom-radio">
    <input type="radio" id="loss" name="typeMatch" value="1" class="custom-control-input">
    <label class="custom-control-label" for="loss">Lost</label>
</div>
    <div class="custom-control custom-radio">
        <input type="radio" id="nowin" name="typeMatch" value="2" class="custom-control-input">
        <label class="custom-control-label" for="nowin">Didn't Win</label>
    </div>
    <div class="custom-control custom-radio">
        <input type="radio" id="draw" name="typeMatch" value="3" class="custom-control-input">
        <label class="custom-control-label" for="draw">Draw</label>
    </div>
<select class="custom-select" name="wrestlerName">
    <c:forEach var="wrestler" items="${wrestlerList}">
    <option value="${wrestler.getWrestlerName()}">${wrestler.getWrestlerName()}</option>
    </c:forEach>
</select>
    <c:if test="${message==0}">
    <span style="color: forestgreen ">O Sheet foi atualizado!</span>
    </c:if>
    <button type="submit" class="float-right">
        Update
    </button>
</form>
</body>

</html>