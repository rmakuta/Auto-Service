<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </tr>
    <tr>
        <td>${employee.name}</td>
        <td>${employee.surname}</td>
        <td>${employee.address}</td>
        <td>${employee.phoneNumber}</td>
        <td>${employee.note}</td>
        <td>${employee.manHourCost}</td>
    </tr>
<%--    <c:forEach items="${employees}" var="employee">--%>
<%--        <tr>--%>
<%--            <td>${employee.name}</td>--%>
<%--            <td>${employee.surname}</td>--%>
<%--            <td>${employee.address}</td>--%>
<%--            <td>${employee.phoneNumber}</td>--%>
<%--            <td>${employee.note}</td>--%>
<%--            <td>${employee.manHourCost}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
</table>
<jsp:include page="/footer.jsp"/>
</body>
</html>
