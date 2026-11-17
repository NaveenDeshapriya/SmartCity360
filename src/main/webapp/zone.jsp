<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SmartCity360 - Zone Control</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-4">
    <span class="navbar-brand fw-bold">SmartCity360</span>
</nav>

<div class="container mt-5">

    <div class="card shadow-sm mx-auto" style="max-width: 650px;">


        <div class="card-body p-4">

            <form method="post" action="${pageContext.request.contextPath}/cityZone">

                <div class="mb-3">
                    <label class="form-label fw-semibold">Select District</label>
                    <select class="form-select" name="district">
                        <option value="Select">Select</option>
                        <option value="Galle District">Galle District</option>
                        <option value="Colombo District">Colombo District</option>

                    </select>
                </div>


                <div class="mb-3">
                    <label class="form-label fw-semibold">Select City</label>

                    <select class="form-select" name="city">
                        <option value="Select">Select</option>
                        <option value="Galle">Galle</option>
                        <option value="Colombo">Colombo</option>
                    </select>

                </div>


                <div class="mb-3">
                    <label class="form-label fw-semibold">Select Street</label>
                    <select class="form-select" name="street">
                        <option value="Select">Select</option>
                        <option value="Galle Street">Galle Street</option>
                        <option value="Colombo Street">Colombo Street</option>
                    </select>
                </div>


                <div class="mb-4">
                    <label class="form-label fw-semibold">Select Building</label>
                    <select class="form-select" name="building">
                        <option value="Select">Select</option>
                        <option value="Galle City Mart">Galle City Mart</option>
                        <option value="Colombo Super city">Colombo Super city</option>
                    </select>
                </div>


                <hr>


                <div class="mb-4">
                    <label class="form-label fw-semibold">ShutDown Zone</label>
                    <select class="form-select" name="shutDown-zone">
                        <option value="Select">Select</option>
                        <option value="District">District</option>
                        <option value="City">City</option>
                        <option value="Street">Street</option>
                        <option value="Building">Building</option>
                    </select>
                </div>


                <div class="d-flex gap-2">
                    <button type="submit" class="btn btn-danger flex-fill">
                        Shutdown Power
                    </button>

                    <a class="btn btn-primary flex-fill" href="zonereport.jsp">
                        Report Usage
                    </a>
                </div>

            </form>

        </div>
    </div>
</div>

</body>

</html>
