<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <jsp:include page="/header.jsp"/>
        </div>
    </div>
    <div class="row">
        <div class="col px-5">
            <p><h5>raport: ROBOCZOGODZINY</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>Imię i Nazwisko</th>
                    <th>Ilość roboczogodzin</th>
                </tr>
                <c:forEach items="${mapNew}" var="m" varStatus="theCount">
                    <tr>
                        <td><strong>${theCount.index+1}</strong></td>
                        <td>${m.getKey()}</td>
                        <td>${m.getValue()}</td>
                    </tr>
                </c:forEach>
            </table>
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
