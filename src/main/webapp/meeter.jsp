
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SmartCity360 - Energy Data Saved</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container min-vh-100 d-flex justify-content-center align-items-center">

    <div class="card shadow border-0 rounded-4" style="width: 100%; max-width: 420px;">

        <div class="card-body p-4 p-md-5">

            <div class="text-center mb-4">
                <h2 class="fw-bold text-primary">SmartCity360</h2>
            </div>


            <form action="${pageContext.request.contextPath}/energyMeeter" method="post">

                <div class="mb-3">
                    <label class="form-label fw-semibold">Username</label>
                    <input type="text"
                            class="form-control form-control-lg"
                            name="username"
                            required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Password</label>
                    <input type="password"
                            class="form-control form-control-lg"
                            name="password"
                            required>

                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Voltage</label>
                    <input type="number"
                            class="form-control form-control-lg"
                            name="voltage"
                            required>

                </div>

                <button type="submit" class="btn btn-primary btn-lg w-100 fw-semibold">Confirm</button>

            </form>


        </div>
    </div>


</div>

</body>
</html>

