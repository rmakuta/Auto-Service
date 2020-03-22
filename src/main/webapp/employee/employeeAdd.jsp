<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employee Add</title>
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
            <h4>Pracownik</h4>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/employeeAdd" method="post">
                <p>Name: <input name="name"></p>
                <p>Surname: <input name="surname"></p>
                <p>Address: <input name="address"></p>
                <p>Phone number: <input name="phoneNumber"></p>
                <p>Note: <input name="note"></p>
                <p>Man-hour cost: <input name="manHourCost"></p>
                <p>
                    <button type="submit">Add</button>
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


