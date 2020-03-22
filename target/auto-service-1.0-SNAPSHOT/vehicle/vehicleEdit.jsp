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
        <div class="col">
            <h4>Edycja pojazdu</h4>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/vehicleEdit" method="post">
                <p>Model: <input name="model" value="${vehicle.model}"></p>
                <p>Marka: <input name="brand" value="${vehicle.brand}"></p>
                <p>Rok produkcji: <input type="date" name="birth" value="${vehicle.birth}"></p>
                <p>Numer rejestracyjny: <input name="regNumber" value="${vehicle.regNumber}"></p>
                <p>Data następnego przeglądu: <input type="date" name="nextServiceDate" value="${vehicle.nextServiceDate}"></p>
                <p>Właściciel:
                    <select name="customerId">
                        <c:forEach items="${customers}" var="customer">
                            <option value="${customer.id}" <c:if test="${vehicle.customerId == customer.id}">selected</c:if>>${customer.name} ${customer.surname}</option>
                        </c:forEach>
                    </select>
                </p>
                <input type="hidden" name="id" value="${vehicle.id}">
                <p>
                    <button type="submit">zapisz</button>
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




