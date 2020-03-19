<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edycja klienta</title>
</head>
<body>
<div class="center">
    <jsp:include page="/header.jsp"/>
    <h2>Klient</h2>
    <form action="/customerEdit" method="post">
        <p>Imię: <input name="name" value="${customer.name}"></p>
        <p>Nazwisko: <input name="surname" value="${customer.surname}"></p>
        <p>Data urodzin: <input type="date" name="birthDate" value="${customer.birthDate}"></p>
        <input type="hidden" name="id" value="${customer.id}">
        <p>
            <button type="submit">zapisz</button>
        </p>
    </form>
    <jsp:include page="/footer.jsp"/>
</div>
</body>
</html>




