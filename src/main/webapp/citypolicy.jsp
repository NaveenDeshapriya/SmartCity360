<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SmartCity360 - City Policy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-4 d-flex justify-content-between">
    <a class="navbar-brand fw-bold" href="dashboard.jsp">SmartCity360</a>
</nav>

<div class="container py-5">

    <div class="card shadow-sm border-0 mb-4">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Add New Rule</h5>
        </div>

        <div class="card-body">

            <div class="mb-3">
                <label class="form-label">Rule Category</label>
                <select id="category" class="form-select" required>
                    <option value="Select">Select category</option>
                    <option value="Noise Limit">Noise Control</option>
                    <option value="Parking Limit">Parking Limits</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Rule No</label>
                <input type="number" id="ruleNo" class="form-control" required>
            </div>


                <div class="mb-3">
                    <label class="form-label">Rule Name</label>
                    <input type="text" id="ruleName" class="form-control" required>
                </div>


                <div class="mb-3">
                    <label for="limit-start"  class="form-label">Start Hours</label>
                    <input type="number" id="limit-start" class="form-control" required>
                </div>

            <div class="mb-3">
                <label for="limit-end"  class="form-label">End Hours</label>
                <input type="number" id="limit-end" class="form-control" required>
            </div>

                <div class="text-end">
                    <button  class="btn btn-primary" onclick="addrule();">Add Rule</button>
                    <button  class="btn btn-primary" onclick="updaterule();">Update Rule</button>
                </div>

        </div>
    </div>

    <div class="card shadow-sm border-0 mb-4">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">City Rules</h5>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light">
                    <tr>
                        <th scope="col">Rule Category</th>
                        <th scope="col">Rule No</th>
                        <th scope="col">Rule Name</th>
                        <th scope="col">Limit</th>
                    </tr>

                    </thead>
                    <tbody id="t-body">

                    </tbody>
                </table>
            </div>
        </div>
    </div>


</div>

<script src="js/script.js"></script>
</body>
</html>
