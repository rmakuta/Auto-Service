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
        <div class="col">
            <h4>Klienci</h4>
        </div>
        <div class="col">
            <form action="/customerSearch" method="post" >
                <p>Nazwisko: <input name="surname">
                    <button type="submit">szukaj</button>
                </p>
            </form>
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
                            <a href="/customerEdit?id=${customer.id}">Edytuj</a>
                            <a href="/customerDelete?id=${customer.id}">Usuń</a>
                            <a href="/customerVehicles?id=${customer.id}">Pojazdy</a>
                            <a href="/customerOrders?id=${customer.id}">Zlecenia</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p class="add"><a href="/customer/customerAdd.jsp">Dodaj nowego klienta</a></p>
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

