<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edycja klienta</title>
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
            <p><h5>Edytuj klienta</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/customerEdit" method="post">
                <div class="form-group col-3">
                    <label>Imię:</label>
                    <input name="name" value="${customer.name}" class="form-control">
                </div>
                <div class="form-group col-3"">
                    <label>Nazwisko:</label>
                    <input name="surname" value="${customer.surname}" class="form-control">
                </div>
                <div class="form-group col-3"">
                    <label>Data urodzin:</label>
                    <input type="date" name="birthDate" value="${customer.birthDate}" class="form-control">
                </div>
                <div class="form-group col-3">
                    <input type="hidden" name="id" value="${customer.id}">
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




