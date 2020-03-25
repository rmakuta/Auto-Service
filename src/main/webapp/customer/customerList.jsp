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
        <div class="col px-5">
            <p><h5>Klienci</h5></p>
        </div>
        <div class="col px-4">
            <p>
                <form action="/customerSearch" method="post" >
                    Nazwisko: <input name="surname">
                        <button type="submit" class="btn btn-info btn-sm">szukaj</button>
                </form>
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Data urodzin</th>
                    <th></th>
                </tr>
                <c:forEach items="${customers}" var="customer" varStatus="theCount">
                    <tr>
                        <td><strong>${theCount.index+1}</strong></td>
                        <td>${customer.name}</td>
                        <td>${customer.surname}</td>
                        <td>${customer.birthDate}</td>
                        <td>
                            <a href="/customerEdit?id=${customer.id}" class="text-info">Edytuj </a>
                            <a href="/customerDelete?id=${customer.id}" class="text-info">Usuń </a>
                            <a href="/customerVehicles?id=${customer.id}" class="text-info">Pojazdy </a>
                            <a href="/customerOrders?id=${customer.id}" class="text-info">Zlecenia</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p><a class="btn btn-info btn-sm" href="/customer/customerAdd.jsp">Dodaj nowego klienta</a><//p>
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

