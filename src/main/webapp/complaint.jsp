
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SmartCity360 - Complaint Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-4 d-flex justify-content-between">
    <a class="navbar-brand fw-bold" href="dashboard.jsp">SmartCity360</a>
</nav>

<div class="container py-5">

    <div class="row justify-content-center">
        <div class="col-md-7">

            <div class="card shadow-sm border-0">
                <div class="card-header bg-primary text-white py-3">
                    <h4 class="mb-0">Send your Complaint</h4>
                </div>

                <div class="card-body p-4">

                    <form method="post" action="${pageContext.request.contextPath}/complaint">

                        <div class="mb-3">
                            <label class="form-label">Resident Name</label>
                            <input type="text" class="form-control" name="name" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Complaint Title</label>
                            <input type="text" class="form-control" name="title" required>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">
                            Send Complaint
                        </button>

                    </form>

                </div>
            </div>

        </div>
    </div>

</div>
</body>
</html>
