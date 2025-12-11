<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        body {
            overflow-x: hidden;
        }
        .navbar {
            .dropdown-menu {
                position:absolute;
                justify-content: end;
            }
        }
        .card {
            border: none;
            .card-body {
                .botton {
                    word-wrap: break-word;
                }
            }
        }
    </style>
</head>

<body>
 <!-- Profile Info -->
    <div class="container py-4">
        <p class="fw-bold fs-1">Welcome, ${sysadmin.username}!</p>
        <p class="fw-bold fs-3">Username </p>
        <p>${sysadmin.username}</p>
        <p class="fw-bold fs-3">Email </p>
        <p>${sysadmin.email}</p>
        <p class="fw-bold fs-3">Password </p>
        <p>****************</p>

        <a href="/sysadmin/home" class="btn btn-danger">Log Out</a>
    </div>
</body>
</html>