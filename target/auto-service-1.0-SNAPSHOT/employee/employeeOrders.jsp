<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Lista zleceń</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>Zlecenia pracownika: ${employee.getName()} ${employee.getSurname()}</h2>
<table>
    <tr>
        <th>Data</th>
        <th>Planowana data naprawy</th>
        <th>Data naprawy</th>
        <th>Prawcownik</th>
        <th>Opis problemu</th>
        <th>Opis naprawy</th>
        <th>Status</th>
        <th>Samochód</th>
        <th>Koszt naprawy</th>
        <th>Koszt części</th>
        <th>Koszt robotogodziny</th>
        <th>Ilość roboczogodzin</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.addDate}</td>
            <td>${order.repairPlannedDate}</td>
            <td>${order.repairDate}</td>
            <td>${employeeDao.read(order.employeeId).getName()} ${employeeDao.read(order.employeeId).getSurname()}</td>
            <td>${order.problemDescription}</td>
            <td>${order.repairDescription}</td>
            <td>${order.status.getDesc()}</td>
            <td>${vehicleDao.read(order.vehicleId).getModel()} ${vehicleDao.read(order.vehicleId).getBrand()}
                    ${vehicleDao.read(order.vehicleId).getRegNumber()}
            </td>
            <td>${order.repairCost}</td>
            <td>${order.carPartsCost}</td>
            <td>${order.manHourCost}</td>
            <td>${order.manHourQuantity}</td>
            <td>
                <a href="/orderEdit?id=${order.id}">Edit</a>
                <a href="/orderDelete?id=${order.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p class="add"><a href="/orderAdd">Dodaj zlecenie</a></p>
<jsp:include page="/footer.jsp"/>
</body>
</html>


