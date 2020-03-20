<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raporty</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>Raporty:</h2>


<ul>
    <li>
        <p><b>Roboczogodziny za okres:</b>
            <form method="get" action="/reportManHours">
                od <input type="date" name="start">
                do <input type="date" name="finish">
                <input type="submit" value="pobierz">
            </form>
        </p>
    </li>
    <li>
        <p><b>Zyski z działalności za okres:</b>
            <form method="get" action="/reportOperatingProfits">
                od <input type="date" name="start">
                do <input type="date" name="finish">
                <input type="submit" value="pobierz">
            </form>
        </p>
    </li>
</ul>
<jsp:include page="/footer.jsp"/>
</body>
</html>
