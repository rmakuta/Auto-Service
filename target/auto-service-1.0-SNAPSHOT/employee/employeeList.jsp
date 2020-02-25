<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Group list</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Address</th>
        <th>Phone number</th>
        <th>Note</th>
        <th>Man hour cost</th>
        <th>Actions</th>
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
                <a href="/employeeEdit?id=${employee.id}">Edit</a>
                <a href="/employeeDelete?id=${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p class="add"><a href="/employee/employeeAdd.jsp">Add new</a></p>
<jsp:include page="/footer.jsp"/>
</body>
</html>
