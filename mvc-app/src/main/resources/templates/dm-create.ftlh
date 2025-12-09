<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        body {
            overflow-x: hidden;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar bg-dark border-bottom border-3 border-secondary" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/home">
                <img src="/d20OutlineWhite.PNG" alt="Nat20 Network" width="30" height="auto" class="d-inline-block align-text-top">
            Nat20 Network
            </a>
            <ul class="navbar-nav">
                <ul class="nav justify-content-left">
                    <!-- Replace nav items with template pages later -->
                    <li class="nav-item">
                        <a class="nav-link" href="tools.html">Tools</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Sign up</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Login</a>
                    </li>
                </ul>
            </ul>
        </div>
    </nav>
    <!-- Create an account -->
    <div class="container justify-content-center" >
        <form id="create-dm" action="/DMs" method="post">
            <p class="fw-bold fs-3">Username </p>
            <input type="text" id="username" name="username" placeholder="Username" required/>
            <p class="fw-bold fs-3">Email </p>
            <input type="email" id="email" name="email" placeholder="Email" required/>
            <p class="fw-bold fs-3">Password </p>
            <input type="text" id="password" name="password" placeholder="Password" required/> </br>
            <div class="container py-4">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href= "/home" class="btn btn-outline-danger">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>