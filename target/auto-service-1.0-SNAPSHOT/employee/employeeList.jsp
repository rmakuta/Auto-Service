<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Lista pracowników</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>Pracownicy</h2>
<table>
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Adres</th>
        <th>Numer telefonu</th>
        <th>Notatka</th>
        <th>Koszt roboczogodziny</th>
        <th></th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.address}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.note}</td>
            <td>${employee.manHourCost}</td>
            <td>
                <a href="/employeeEdit?id=${employee.id}">Edytuj</a>
                <a href="/employeeDelete?id=${employee.id}">Usuń</a>
                <a href="/employeeOrders?id=${employee.id}">Zlecenia</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p class="add"><a href="/employee/employeeAdd.jsp">Dodaj nowego pracownika</a></p>
<jsp:include page="/footer.jsp"/>
</body>
</html>
