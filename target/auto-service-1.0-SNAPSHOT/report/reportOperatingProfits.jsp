<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="/header.jsp"/>
<body>
<h2>Raport: zyski z działalności</h2>
<table>
    <tr>
        <th>Przychody</th>
        <th>Koszty części</th>
        <th>Koszt roboczogodzin</th>
        <th>Zysk</th>
    </tr>
    <c:forEach items="${operatingProfit}" var="op">
        <td><fmt:formatNumber type="currency">${op}</fmt:formatNumber></td>
    </c:forEach>
</table>
</body>
<jsp:include page="/footer.jsp"/>
</html>
