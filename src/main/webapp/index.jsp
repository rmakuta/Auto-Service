<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Auto service</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <jsp:include page="/header.jsp"/>
        </div>
    </div>
    <div class="row">
        <div class="col px-5">
            <p><h5>Aktualne zlecenia</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>Data przyjęcia</th>
                    <th>Planowana data naprawy</th>
                    <th>Samochód</th>
                    <th>Opis problemu</th>
                    <th></th>
                </tr>
                <c:forEach items="${orders}" var="order" varStatus="theCount">
                    <tr>
                        <td><strong>${theCount.index+1}.</strong></td>
                        <td>${order.addDate}</td>
                        <td>${order.repairPlannedDate}</td>
                        <td>${vehicleDao.read(order.vehicleId).brand} ${vehicleDao.read(order.vehicleId).model} [
                                ${vehicleDao.read(order.vehicleId).regNumber}]</td>
                        <td>${order.problemDescription}</td>
                        <td>
                            <a href="" class="text-info" type="button" data-toggle="collapse" data-target="#collapseThree${theCount.index}"
                               aria-expanded="false" aria-controls="collapseThree${theCount.index}">Szczegóły</a>
<%--                            <a href="/orderEdit?id=${order.id}" class="text-info">Edytuj</a>--%>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6">
                            <div class="accordion" id="accordionExample">
                                <div id="collapseThree${theCount.index}" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                                    Właściciel samochodu: <strong>${customerDao.read(vehicleDao.read(order.vehicleId).customerId).name}
                                        ${customerDao.read(vehicleDao.read(order.vehicleId).customerId).surname}</strong>
                                    Opis naprawy: <strong>${order.repairDescription}</strong> Status: <strong>${order.status.getDesc()}</strong>
                                    Pracownik: <strong>${employeeDao.read(order.employeeId).name} ${employeeDao.read(order.employeeId).surname}</strong>
                                    Koszt naprawy: <strong><fmt:formatNumber type="currency">${order.repairCost}</fmt:formatNumber></strong>
                                    Koszt części: <strong><fmt:formatNumber type="currency">${order.carPartsCost}</fmt:formatNumber></strong>
                                    Koszt roboczogodziny: <strong><fmt:formatNumber type="currency">${order.manHourCost}</fmt:formatNumber></strong>
                                    Ilość roboczogodzin: <strong>${order.manHourQuantity}</strong>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
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
