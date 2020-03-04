<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Dodanie pojazdu</title>
</head>
<body>
<div class="center">
    <jsp:include page="/header.jsp"/>
    <h2>Dodanie pojazdu</h2>
    <form action="/vehicleAdd" method="post">
        <p>Model: <input name="model"></p>
        <p>Marka: <input name="brand"></p>
        <p>Rok produkcji: <input name="birth"></p>
        <p>Numer rejestracyjny: <input name="regNumber"></p>
        <p>Data następnego przeglądu: <input name="nextServiceDate"></p>
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
    <jsp:include page="/footer.jsp"/>
</div>
</body>
</html>



