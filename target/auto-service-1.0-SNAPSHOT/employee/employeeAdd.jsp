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
        <div class="col px-4">
            <p><h5>Pracownik</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/employeeAdd" method="post">
                <div class="form-group col-3">
                    <label>Imię:</label>
                    <input name="name" class="form-control" placeholder="Wpisz imię">
                </div>
                <div class="form-group col-3">
                    <label>Nazwisko:</label>
                    <input name="surname" class="form-control" placeholder="Wpisz nazwisko">
                </div>
                <div class="form-group col-3">
                    <label>Adres:</label>
                    <input name="address" class="form-control" placeholder="Wpisz adres">
                </div>
                <div class="form-group col-3">
                    <label>Numer telefonu:</label>
                    <input name="phoneNumber" class="form-control" placeholder="Wpisz numer telefonu"></p>
                </div>
                <div class="form-group col-3">
                    <label>Notatka:</label>
                    <input name="note" class="form-control"></p>
                </div>
                <div class="form-group col-3">
                    <label>Koszt roboczogodziny:</label>
                    <input name="manHourCost" class="form-control">
                </div>
                <div class="form-group col-3">
                    <button type="submit" class="btn btn-info btn-sm">Dodaj</button>
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


