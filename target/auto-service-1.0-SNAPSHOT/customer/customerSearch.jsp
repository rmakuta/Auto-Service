<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Lista klientów</title>
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
            <p><h5>Klienci</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <tr>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Data urodzin</th>
                    <th></th>
                </tr>
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td>${customer.name}</td>
                        <td>${customer.surname}</td>
                        <td>${customer.birthDate}</td>
                        <td>
                            <a href="/customerEdit?id=${customer.id}" class="text-info">Edytuj</a>
                            <a href="/customerDelete?id=${customer.id}" class="text-info">Usuń</a>
                            <a href="/customerVehicles?id=${customer.id}" class="text-info">Pojazdy</a>
                            <a href="/customerOrders?id=${customer.id}" class="text-info">Zlecenia</a>
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

