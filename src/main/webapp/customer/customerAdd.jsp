<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Dodanie klienta</title>
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
            <p><h5>Dodaj klienta</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/customerAdd" method="post">
                <div class="form-group col-3">
                    <label>Imię: </label>
                    <input name="name" class="form-control" placeholder="Wpisz imię">
                </div>
                <div class="form-group col-3">
                    <label>Nazwisko: </label>
                    <input name="surname" class="form-control" placeholder="Wpisz nazwisko">
                </div>
                <div class="form-group col-3">
                    <label>Data urodzin: </label>
                    <input type="date" name="birthDate" class="form-control">
                </div>
                <div class="col-3">
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


