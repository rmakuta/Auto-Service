<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Zamówienie edycja</title>
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
            <p><h5>Edycja zamówienia</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/orderEdit" method="post">
                <div class="form-group col-3">
                    <label>Data przyjęcia:</label>
                    <input type="date" name="addDate" value="${order.addDate}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Planowana data naprawy:</label>
                    <input type="date" name="repairPlannedDate" value="${order.repairPlannedDate}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Data naprawy:</label>
                    <input type="date" name="repairDate" value="${order.repairDate}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Pracownik:</label>
                    <select name="employeeId" class="form-control">
                        <c:forEach items="${employees}" var="employee">
                            <option value="${employee.id}" <c:if test="${order.employeeId == employee.id}">selected</c:if>>${employee.name} ${employee.surname}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-3">
                    <label>Opis problemu:</label>
                    <input name="problemDescription" value="${order.problemDescription}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Opis naprawy:</label>
                    <input name="repairDescription" value="${order.repairDescription}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Status:</label>
                    <select name="status" class="form-control">
                        <c:forEach items="${statuses}" var="status">
                            <option value="${status.name()}" <c:if test="${order.status == status.name()}">selected</c:if>>${status.getDesc()} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-3">
                    <label>Samochód:</label>
                    <select name="vehicleId" class="form-control">
                        <c:forEach items="${vehicles}" var="vehicle">
                            <option value="${vehicle.id}" <c:if test="${order.vehicleId == vehicle.id}">selected</c:if>>${vehicle.getBrand()} ${vehicle.getModel()} [${vehicle.getRegNumber()}]</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-3">
                    <label>Koszt części:</label>
                    <input name="carPartsCost" value="${order.carPartsCost}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Ilość roboczogodzin:</label>
                    <input name="manHourQuantity" value="${order.manHourQuantity}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <input type="hidden" name="id" value="${order.id}">
                    <button type="submit" class="btn btn-info btn-sm">Zapisz</button>
                </div>
            </form>
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




