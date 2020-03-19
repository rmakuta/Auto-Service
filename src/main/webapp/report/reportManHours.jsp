<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="/header.jsp"/>
<body>
<h2>Raport: roboczogodziny</h2>
<table>
    <tr>
        <th>Imię i Nazwisko</th>
        <th>Ilość roboczogodzin</th>
    </tr>
    <c:forEach items="${mapNew}" var="m">
        <tr>
            <td>${m.getKey()}</td>
            <td>${m.getValue()}</td>
        </tr>
    </c:forEach>
</table>
</body>
<jsp:include page="/footer.jsp"/>
</html>
