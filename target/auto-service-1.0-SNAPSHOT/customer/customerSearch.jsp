<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Lista klientów</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>Klienci</h2>
<table>
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Data urodzin</th>
        <th></th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.birthDate}</td>
            <td>
                <a href="/customerEdit?id=${customer.id}">Edytuj</a>
                <a href="/customerDelete?id=${customer.id}">Usuń</a>
                <a href="/customerVehicles?id=${customer.id}">Pojazdy</a>
                <a href="/customerOrders?id=${customer.id}">Zlecenia</a>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/footer.jsp"/>
</body>
</html>

