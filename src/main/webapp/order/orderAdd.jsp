<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Order Add</title>
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
            <h4>Zlecenie naprawy</h4>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/orderAdd" method="post">
        <%--        <p>Data: <input name="addDate"></p>--%>
                <p>Planowana data naprawy: <input type="date" name="repairPlannedDate"></p>
        <%--        <p>Data naprawy: <input name="repairDate"></p>--%>
                <p>Pracownik:
                    <select name="employeeId">
                        <c:forEach items="${employees}" var="employee">
                            <option value="${employee.id}">${employee.name} ${employee.surname}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>Opis problemu: <input name="problemDescription"></p>
                <p>Opis naprawy: <input name="repairDescription"></p>
                <p>Status:
                    <select name="status">
                        <c:forEach items="${statuses}" var="status">
                            <option value="${status.name()}">${status.getDesc()} </option>
                        </c:forEach>
                    </select>
                </p>
                <p>Samochód:
                    <select name="vehicleId">
                        <c:forEach items="${vehicles}" var="vehicle">
                            <option value="${vehicle.id}">${vehicle.getModel()} ${vehicle.getBrand()} ${vehicle.getRegNumber()}</option>
                        </c:forEach>
                    </select>
                </p>
        <%--        <p>Koszt naprawy: <input name="repairCost"></p>--%>
                <p>Koszt części: <input name="carPartsCost"></p>
        <%--        <p>Koszt roboczogodziny: ${employee.manHourCost}--%>
        <%--            <input name="manHourCost">--%>
        <%--        </p>--%>
                <p>Ilość roboczogodzin: <input name="manHourQuantity"></p>
                <p>
                    <button type="submit">Add</button>
                </p>
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



