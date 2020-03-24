<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            <p><h5>Naprawy pojazdu: ${vehicle.getModel()} ${vehicle.getBrand()} ${vehicle.getRegNumber()}</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
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
                        <td>
                                ${vehicleDao.read(order.vehicleId).getBrand()} ${vehicleDao.read(order.vehicleId).getModel()}
                                [${vehicleDao.read(order.vehicleId).getRegNumber()}]
                        </td>
                        <td>${order.repairCost}</td>
                        <td>${order.carPartsCost}</td>
                        <td>${order.manHourCost}</td>
                        <td>${order.manHourQuantity}</td>
                        <td>
                            <a href="/orderEdit?id=${order.id}" class="text-info">Edytuj</a>
                            <a href="/orderDelete?id=${order.id}" class="text-info">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p><a href="/orderAdd" class="btn btn-info btn-sm">Dodaj zlecenie</a></p>
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


