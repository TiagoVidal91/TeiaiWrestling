<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <link rel="stylesheet" href="/css/styles2.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#matchType").change(function () {
                if ($(this).val() == "4-Man") {
                    $("#four-match").show();
                } else {
                    $("#four-match").hide();
                }
            });
        });
    </script>

</head>
<body>

<!-- Image and text -->
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/">
        <img src="/docs/4.1/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
        HomePage
    </a>
</nav>
<form:form method="post">
    <div>
        <label><b>Type of Match:</b></label>
    <select class="custom-select" name="matchType" id="matchType">
        <c:forEach var="matchtype" items="${matchtypelist}">
            <option value="${matchtype.getName()}">${matchtype.getName()}</option>
        </c:forEach>
    </select>
    </div>

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
    <div>
        <label><b>Didn't Win:</b></label>
        <select class="custom-select" name="noWin">
            <c:forEach var="wrestler" items="${wrestlernames}">
                <option value="${wrestler.getWrestlerName()}">${wrestler.getWrestlerName()}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label><b>Draw:</b></label>
        <select class="custom-select" name="draw">
            <c:forEach var="wrestler" items="${wrestlernames}">
                <option value="${wrestler.getWrestlerName()}">${wrestler.getWrestlerName()}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label><b>Draw:</b></label>
        <select class="custom-select" name="draw">
            <c:forEach var="wrestler" items="${wrestlernames}">
                <option value="${wrestler.getWrestlerName()}">${wrestler.getWrestlerName()}</option>
            </c:forEach>
        </select>
    </div>
    </div>

    <div class="four-match" id="four-match" style="display: none">
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
        <div>
            <label><b>Didn't Win:</b></label>
            <select class="custom-select" name="noWin">
                <c:forEach var="wrestler" items="${wrestlernames}">
                    <option value="${wrestler.getWrestlerName()}">${wrestler.getWrestlerName()}</option>
                </c:forEach>
            </select>
        </div>
    </div>


    <c:if test="${message==0}">
        <span style="color: forestgreen ">O Sheet foi atualizado!</span>
    </c:if>

    <button type="submit" class="float-right">
        Update
    </button>
</form:form>
</body>

</html>