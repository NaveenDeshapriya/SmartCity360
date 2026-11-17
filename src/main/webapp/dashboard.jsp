<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SmartCity360 -Energy Meters</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-4 d-flex justify-content-between">
    <a class="navbar-brand fw-bold" href="dashboard.jsp">SmartCity360</a>
    <div class="flex-row gap-3 ">
        <a class="navbar-brand fs-6" href="zone.jsp">Zone Control</a>
        <a class="navbar-brand fs-6" href="complaint.jsp">Complaint</a>
        <a class="navbar-brand fs-6" href="streetlight.jsp">StreetLight Manage</a>
        <a class="navbar-brand fs-6" href="citypolicy.jsp">City Policy</a>
    </div>
</nav>

<div class="container mt-4">

    <div class="card shadow-sm">

        <div class="card-header bg-white">
            <h5 class="mb-0">Meter Data</h5>
        </div>

        <div class="card-body">

            <div class="table-responsive">
                <table class="table table-hover align-middle">

                    <tbody>
                    <c:forEach var="data" items="${sessionScope.data}" >
                        <tr>
                            <td>${data}</td>
                        </tr>

                    </c:forEach>

                    </tbody>

                </table>
            </div>

        </div>
    </div>

</div>

</body>
</html>

