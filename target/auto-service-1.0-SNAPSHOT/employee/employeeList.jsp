<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Lista pracowników</title>
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
            <p><h5>Pracownicy</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Adres</th>
                    <th>Numer telefonu</th>
                    <th>Notatka</th>
                    <th>Koszt roboczogodziny</th>
                    <th></th>
                </tr>
                <c:forEach items="${employees}" var="employee" varStatus="theCount">
                    <tr>
                        <td><strong>${theCount.index+1}</strong></td>
                        <td>${employee.name}</td>
                        <td>${employee.surname}</td>
                        <td>${employee.address}</td>
                        <td>${employee.phoneNumber}</td>
                        <td>${employee.note}</td>
                        <td><fmt:formatNumber type="currency">${employee.manHourCost}</fmt:formatNumber></td>
                        <td>
                            <a href="/employeeEdit?id=${employee.id}" class="text-info">Edytuj</a>
                            <a href="/employeeDelete?id=${employee.id}" class="text-info">Usuń</a>
                            <a href="/employeeOrders?id=${employee.id}" class="text-info">Zlecenia</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p><a class="btn btn-info btn-sm float-none" href="/employee/employeeAdd.jsp">Dodaj nowego pracownika</a></p>
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
