<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Dodanie pojazdu</title>
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
            <h4>Dodanie pojazdu</h4>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/vehicleAdd" method="post">
                <p>Model: <input name="model"></p>
                <p>Marka: <input name="brand"></p>
                <p>Rok produkcji: <input type="date" name="birth"></p>
                <p>Numer rejestracyjny: <input name="regNumber"></p>
                <p>Data następnego przeglądu: <input type="date" name="nextServiceDate"></p>
                <p>Właściciel:
                    <select name="customerId">
                        <c:forEach items="${customers}" var="customer">
                            <option value="${customer.id}">${customer.name} ${customer.surname}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <button type="submit">dodaj</button>
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



