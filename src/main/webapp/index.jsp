<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Auto service</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<table>
    <tr>
        <th>Data przyjęcia</th>
        <th>Opis problemu</th>
        <th></th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.addDate}</td>
            <td>${order.problemDescription}</td>
            <td><a href="/orderEdit?id=${order.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/footer.jsp"/>
</body>
</html>
