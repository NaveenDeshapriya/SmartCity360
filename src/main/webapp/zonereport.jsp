<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SmartCity360 - Zone Power Report</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-4">
    <span class="navbar-brand fw-bold">SmartCity360</span>
</nav>

<div class="card shadow-sm border-0">
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-hover align-middle">
                <thead class="table-light">

                </thead>

                <tbody>

                <c:forEach var="report" items="${sessionScope.report}">

                    <tr>
                        <td>${report}</td>
                    </tr>

                </c:forEach>


                </tbody>
            </table>
        </div>

    </div>
</div>

</body>
</html>
