<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edycja pojazdu</title>
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
            <p><h5>Edycja pojazdu</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/vehicleEdit" method="post">
                <div class="form-group col-3">
                    <label>Marka:</label>
                    <input name="brand" value="${vehicle.brand}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Model:</label>
                    <input name="model" value="${vehicle.model}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Rok produkcji:</label>
                    <input type="date" name="birth" value="${vehicle.birth}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Numer rejestracyjny:</label>
                    <input name="regNumber" value="${vehicle.regNumber}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Data następnego przeglądu:</label>
                    <input type="date" name="nextServiceDate" value="${vehicle.nextServiceDate}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Właściciel:</label>
                    <select name="customerId" class="form-control">
                        <c:forEach items="${customers}" var="customer">
                            <option value="${customer.id}" <c:if test="${vehicle.customerId == customer.id}">selected</c:if>>${customer.name} ${customer.surname}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-3">
                    <input type="hidden" name="id" value="${vehicle.id}">
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




