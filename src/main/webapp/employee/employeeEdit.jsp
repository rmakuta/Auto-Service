<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employee edit</title>
</head>
<body>
<div class="center">
    <jsp:include page="/header.jsp"/>
    <h2>Employee</h2>
    <form action="/employeeEdit" method="post">
        <p>Name: <input name="name" value="${employee.name}"></p>
        <p>Surname: <input name="surname" value="${employee.surname}"></p>
        <p>Address: <input name="address" value="${employee.address}"></p>
        <p>Phone number: <input name="phoneNumber" value="${amployee.phoneNumber}"></p>
        <p>Note: <input name="note" value="${employee.note}"></p>
        <p>Man-hour cost: <input name="manHourCost" value="${employee.manHourCost}"></p>
                          <input type="hidden" name="id" value="${employee.id}">
        <p>
            <button type="submit">save</button>
        </p>
    </form>
    <jsp:include page="/footer.jsp"/>
</div>
</body>
</html>



