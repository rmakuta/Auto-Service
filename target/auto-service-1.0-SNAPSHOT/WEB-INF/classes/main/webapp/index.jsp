<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.addDate}</td>
            <td>${order.problemDesription}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/footer.jsp"/>
</body>
</html>
