<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SmartCity360 - Streetlight Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-4 d-flex justify-content-between">
    <a class="navbar-brand fw-bold" href="dashboard.jsp">SmartCity360</a>
</nav>

<div class="container py-5">

    <div class="card shadow-sm border-0 mb-4">

        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Register Streetlight</h5>
        </div>

        <div class="card-body">

            <form method="post" action="${pageContext.request.contextPath}/streetLight">

                <div class="row g-3">

                    <div class="col-md-6">
                        <label class="form-label">Location</label>
                        <input type="text" name="location" class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label  class="form-label">Type</label>
                        <select name="type" class="form-select" required>
                            <option value="">Select type</option>
                            <option value="LED">LED</option>
                            <option value="Smart LED">Smart LED</option>
                        </select>
                    </div>

                    <div class="col-md-6">
                        <label  class="form-label">Color</label>
                        <input type="text" name="color" class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label  class="form-label">Brightness</label>
                        <input type="number" name="brightness"  class="form-control" required>
                    </div>

                    <div class="col-md-6">
                        <label  class="form-label">Status</label>
                        <select name="status" class="form-select" required>
                            <option value="">Select status</option>
                            <option value="ON">ON</option>
                            <option value="OFF">OFF</option>
                        </select>
                    </div>



                </div>

                <div class="mt-4 text-end">
                    <button type="submit" class="btn btn-primary">
                        Register Streetlight
                    </button>
                </div>

            </form>

        </div>
    </div>

    <div class="card shadow-sm border-0">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Streetlight Locations</h5>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light">
                    <tr>
                        <th>Location</th>
                        <th>Type</th>
                        <th>color</th>
                        <th>brightness</th>
                        <th>Status</th>
                    </tr>
                    </thead>

                    <tbody>

                    <c:forEach var="streetLight" items="${sessionScope.streetLights}">

                        <tr>
                            <td>${streetLight.getLocation()}</td>
                            <td><span >${streetLight.getType()}</span></td>
                            <td><span >${streetLight.getColor()}</span></td>
                            <td><span >${streetLight.getBrightness()}</span></td>
                            <td><span class="badge bg-success">${streetLight.getStatus()}</span></td>
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
