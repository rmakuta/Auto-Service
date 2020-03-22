<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Dodanie klienta</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <jsp:include page="/header.jsp"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <h4>Klient</h4>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/customerAdd" method="post">
                <p>Imię: <input name="name"></p>
                <p>Nazwisko: <input name="surname"></p>
                <p>Data urodzin: <input type="date" name="birthDate"></p>
                <p> <button type="submit">Dodaj</button> </p>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <jsp:include page="/footer.jsp"/>
        </div>
    </div>
</div>
</body>
</html>


