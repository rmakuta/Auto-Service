<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raporty</title>
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
            <p><h5>Raporty:</h5></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
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
