<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employee edit</title>
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
            <h4>Employee</h4>
        </div>
    </div>
    <div class="row">
        <div class="col">
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



