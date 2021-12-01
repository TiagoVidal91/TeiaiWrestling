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
<div class="single" id="single">
    <div>
        <label><b>Winner of Match:</b></label>
        <select class="custom-select" name="victory">
            <c:forEach var="wrestler" items="${wrestlernames}">
                <option value="${wrestler.getWrestlerName()}">${wrestler.getWrestlerName()}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label><b>Loser of Match:</b></label>
        <select class="custom-select" name="loss">
            <c:forEach var="wrestler" items="${wrestlernames}">
                <option value="${wrestler.getWrestlerName()}">${wrestler.getWrestlerName()}</option>
            </c:forEach>
        </select>
    </div>
</div>
    <c:if test="${message==0}">
        <span style="color: forestgreen ">O Sheet foi atualizado!</span>
    </c:if>
    <c:if test="${message==1}">
        <span style="color: forestgreen ">Verifique a informação!</span>
    </c:if>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" id="flexCheckChecked" name="draw">
        <label class="form-check-label" for="flexCheckChecked"><b>Draw</b>
        </label>
    </div>
    <button type="submit" class="float-right">
        Update
    </button>
</form>
</body>
</html>