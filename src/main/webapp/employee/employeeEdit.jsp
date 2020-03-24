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
        <div class="col px-4">
            <p><h5>Edycja pracownika</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/employeeEdit" method="post">
                <div class="form-group col-3">
                    <label>Imię:</label>
                    <input name="name" value="${employee.name}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Nazwisko:</label>
                    <input name="surname" value="${employee.surname}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Adres:</label>
                    <input name="address" value="${employee.address}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Numer telefonu:</label>
                    <input name="phoneNumber" value="${employee.phoneNumber}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Notatka:</label>
                    <input name="note" value="${employee.note}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <label>Koszt roboczogodziny</label>
                    <input name="manHourCost" value="${employee.manHourCost}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <input type="hidden" name="id" value="${employee.id}">
                    <button type="submit" class="btn btn-info btn-sm">Zapisz</button>
                </div>
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



