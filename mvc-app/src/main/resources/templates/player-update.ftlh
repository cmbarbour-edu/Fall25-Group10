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
        .navbar {
            .dropdown-menu {
                position:absolute;
                justify-content: end;
            }
        }
        .card{
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar bg-dark boarder-bottom border-3 border-secondary" data-bs-theme="dark">
        <div class="container-fluid" position="relative">
            <a class="navbar-brand" href="/players/${players.id}/home">
                <img src="/d20OutlineWhite.PNG" alt="Nat20 Network" width="30" height="auto" class="d-inline-block align-text-top">
            Nat20 Network
            </a>
            <ul class="navbar-nav justify-content-center">
                <ul class="nav justify-content-left">
                    <li class="nav-item align-middle">
                        <a class="nav-link" href="/high-fidelity-prototype/tools.html">Tools</a>
                    </li>
                    
                    <li class="nav-item dropdown-center">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Profile
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-dark">
                            <li><a class="dropdown-item" href="/players/${player.id}/profile">Manage profile</a></li>
                            <li><a class="dropdown-item" href="/players/${player.id}/home">Home</a></li>
                            
                            <li><a class="dropdown-item" href="/home">Log Out</a></li>
                        </ul>
                    </li>
                </ul>
            </ul>
        </div>
    </nav>
    <!-- Profile Info -->
    <div class="container py-4">
        <p class="fw-bold fs-1">Welcome, ${player.username}!</p>
        <form id="update-dm" action="/players/${player.id}" method="post">
            <p class="fw-bold fs-3">Username </p>
            <input type="text" id="username" name="username" value="${player.username}" placeholder="Username" required/>
            <p class="fw-bold fs-3">Email </p>
            <input type="email" id="email" name="email" value="${player.email}" placeholder="Email" required/>
            <p class="fw-bold fs-3">Password </p>
            <input type="text" id="password" name="password" value="${player.password}" placeholder="Password" required/> </br>
            <div class="container py-4">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href= "/players/${player.id}/profile" class="btn btn-outline-danger">Cancel</a>
            </div>
        </form>
        
        <a href="/players/${player.id}/delete" class="btn btn-danger">Delete account</a>
    </div>
</body>
</html>