<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Lista zleceń</title>
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
            <p><h5>Zlecenia</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <tr>
                    <th>Data</th>
                    <th>Planowana data naprawy</th>
                    <th>Data naprawy</th>
                    <th>Pracownik</th>
                    <th>Opis problemu</th>
                    <th>Opis naprawy</th>
                    <th>Status</th>
                    <th>Samochód</th>
                    <th>Koszt naprawy</th>
                    <th>Koszt części</th>
                    <th>Koszt roboczo.</th>
                    <th>Ilość roboczo.</th>
                    <th></th>
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
                        <td>${vehicleDao.read(order.vehicleId).getBrand()} ${vehicleDao.read(order.vehicleId).getModel()}
                                [${vehicleDao.read(order.vehicleId).getRegNumber()}]
                        </td>
                        <td><fmt:formatNumber type="currency">${order.repairCost}</fmt:formatNumber></td>
                        <td><fmt:formatNumber type="currency">${order.carPartsCost}</fmt:formatNumber></td>
                        <td><fmt:formatNumber type="currency">${order.manHourCost}</fmt:formatNumber></td>
                        <td>${order.manHourQuantity}</td>
                        <td>
                            <a href="/orderEdit?id=${order.id}" class="text-info">Eytuj</a>
                            <a href="/orderDelete?id=${order.id}" class="text-info">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <p><a class="btn btn-info btn-sm" href="/orderAdd">Dodaj nowe zlecenie</a></p>
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

