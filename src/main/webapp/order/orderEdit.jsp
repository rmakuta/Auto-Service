<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Zamówienie edycja</title>
</head>
<body>
<div class="center">
    <jsp:include page="/header.jsp"/>
    <h2>Edycja zamówienia</h2>
    <form action="/orderEdit" method="post">
        <p>Data przyjęcia: <input type="date" name="addDate" value="${order.addDate}"></p>
        <p>Planowana data naprawy: <input type="date" name="repairPlannedDate" value="${order.repairPlannedDate}"></p>
        <p>Data naprawy: <input type="date" name="repairDate" value="${order.repairDate}"></p>
        <p>Pracownik:
            <select name="employeeId">
                <c:forEach items="${employees}" var="employee">
                    <option value="${employee.id}" <c:if test="${order.employeeId == employee.id}">selected</c:if>>${employee.name} ${employee.surname}</option>
                </c:forEach>
            </select>
        </p>
        <p>Opis problemu: <input name="problemDescription" value="${order.problemDescription}"></p>
        <p>Opis naprawy: <input name="repairDescription" value="${order.repairDescription}"></p>
        <p>Status:
            <select name="status">
                <c:forEach items="${statuses}" var="status">
                    <option value="${status.name()}" <c:if test="${order.status == status.name()}">selected</c:if>>${status.getDesc()} </option>
                </c:forEach>
            </select>
        </p>
        <p>Samochód:
            <select name="vehicleId">
                <c:forEach items="${vehicles}" var="vehicle">
                    <option value="${vehicle.id}" <c:if test="${order.vehicleId == vehicle.id}">selected</c:if>>${vehicle.getModel()} ${vehicle.getBrand()} ${vehicle.getRegNumber()}</option>
                </c:forEach>
            </select>
        </p>
        <p>Koszt części: <input name="carPartsCost" value="${order.carPartsCost}"></p>
        <p>Ilość roboczogodzin: <input name="manHourQuantity" value="${order.manHourQuantity}"></p>
        <input type="hidden" name="id" value="${order.id}">
        <p>
            <button type="submit">zapisz</button>
        </p>
    </form>
    <jsp:include page="/footer.jsp"/>
</div>
</body>
</html>




