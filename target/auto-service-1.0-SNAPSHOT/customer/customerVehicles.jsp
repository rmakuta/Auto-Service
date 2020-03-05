<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Lista pojazdów</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>Pojazdy klienta: ${customer.getName()} ${customer.getSurname()}</h2>
<table>
    <tr>
        <th>Model</th>
        <th>Marka</th>
        <th>Data produkcji</th>
        <th>Numer rejestracyjny</th>
        <th>Data kolejnego przeglądu</th>
        <th>Właściciel</th>
    </tr>
    <c:forEach items="${vehicles}" var="vehicle">
        <tr>
            <td>${vehicle.model}</td>
            <td>${vehicle.brand}</td>
            <td>${vehicle.birth}</td>
            <td>${vehicle.regNumber}</td>
            <td>${vehicle.nextServiceDate}</td>
            <td>${customerDao.read(vehicle.customerId).getName()} ${customerDao.read(vehicle.customerId).getSurname()}</td>
            <td>
                <a href="vehicleEdit?id=${vehicle.id}">Edit</a>
                <a href="/vehicleDelete?id=${vehicle.id}">Delete</a>
                <a href="/vehicleOrders?id=${vehicle.id}">Naprawy</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p class="add"><a href="/vehicleAdd">Dodaj nowy pojazd</a></p>
<jsp:include page="/footer.jsp"/>
</body>
</html>


