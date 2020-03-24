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
        <div class="col px-4">
            <p><h5>Zlecenie naprawy</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/orderAdd" method="post">
                <div class="form-group col-3">
                    <label>Planowana data naprawy:</label>
                    <input type="date" name="repairPlannedDate" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Pracownik:</label>
                    <select name="employeeId" class="form-control">
                        <c:forEach items="${employees}" var="employee">
                            <option value="${employee.id}">${employee.name} ${employee.surname}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-3">
                    <label>Opis problemu:</label>
                    <input name="problemDescription" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Opis naprawy:</label>
                    <input name="repairDescription" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Status:</label>
                    <select name="status" class="form-control">
                        <c:forEach items="${statuses}" var="status">
                            <option value="${status.name()}">${status.getDesc()} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-3">
                    <label>Samochód:</label>
                    <select name="vehicleId" class="form-control">
                        <c:forEach items="${vehicles}" var="vehicle">
                            <option value="${vehicle.id}">${vehicle.getModel()} ${vehicle.getBrand()} ${vehicle.getRegNumber()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-3">
                    <label>Koszt części:</label>
                    <input name="carPartsCost" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Ilość roboczogodzin:</label>
                    <input name="manHourQuantity" class="form-control">
                </div>
                <div class="form-group col-3">
                    <button type="submit" class="btn btn-info btn-sm">Dodaj</button>
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



