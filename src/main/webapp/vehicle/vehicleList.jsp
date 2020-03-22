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
        <div class="col">
            <h4>Pojazdy</h4>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <tr>
                    <th>Model</th>
                    <th>Marka</th>
                    <th>Data produkcji</th>
                    <th>Numer rejestracyjny</th>
                    <th>Data kolejnego przeglądu</th>
                    <th>Właściciel</th>
                    <th></th>
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
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p class="nav-link"><a href="/vehicleAdd">Dodaj nowy pojazd</a></p>
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

