<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Lista pojazdów</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <jsp:include page="/header.jsp"/>
        </div>
    </div>
    <div class="row">
        <div class="col px-4">
            <p><h5>Pojazdy klienta: ${customer.getName()} ${customer.getSurname()}</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <tr>
                    <th>Marka</th>
                    <th>Model</th>
                    <th>Data produkcji</th>
                    <th>Numer rejestracyjny</th>
                    <th>Data kolejnego przeglądu</th>
                    <th>Właściciel</th>
                    <th></th>
                </tr>
                <c:forEach items="${vehicles}" var="vehicle">
                    <tr>
                        <td>${vehicle.brand}</td>
                        <td>${vehicle.model}</td>
                        <td>${vehicle.birth}</td>
                        <td>${vehicle.regNumber}</td>
                        <td>${vehicle.nextServiceDate}</td>
                        <td>${customerDao.read(vehicle.customerId).getName()} ${customerDao.read(vehicle.customerId).getSurname()}</td>
                        <td>
                            <a href="vehicleEdit?id=${vehicle.id}" class="text-info">Edytuj</a>
                            <a href="/vehicleDelete?id=${vehicle.id}" class="text-info">Usuń</a>
                            <a href="/vehicleOrders?id=${vehicle.id}" class="text-info">Naprawy</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p><a class="btn btn-info btn-sm" href="/vehicleAdd">Dodaj nowy pojazd</a></p>
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


