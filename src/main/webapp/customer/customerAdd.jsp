<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Dodanie klienta</title>
</head>
<body>
<div class="center">
    <jsp:include page="/header.jsp"/>
    <h2>Klient</h2>
    <form action="/customerAdd" method="post">
        <p>Imię: <input name="name"></p>
        <p>Nazwisko: <input name="surname"></p>
        <p>Data urodzin: <input name="birthDate"></p>
        <p>
            <button type="submit">Dodaj</button>
        </p>
    </form>
    <jsp:include page="/footer.jsp"/>
</div>
</body>
</html>


