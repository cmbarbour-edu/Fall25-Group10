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
    <!-- Navbar -->
    <nav class="navbar bg-dark boarder-bottom border-3 border-secondary" data-bs-theme="dark">
        <div class="container-fluid" position="relative">
            <a class="navbar-brand" href="/DMs/${DM.dmID}/home">
                <img src="/d20OutlineWhite.PNG" alt="Nat20 Network" width="30" height="auto" class="d-inline-block align-text-top">
            Nat20 Network
            </a>
            <ul class="navbar-nav justify-content-center">
                <ul class="nav justify-content-left">
                    <li class="nav-item align-middle">
                        <a class="nav-link" href="/high-fidelity-prototype/tools.html">Tools</a>
                    </li>
                    <li class="nav-item align-middle">
                        <a class="nav-link" href="/DMs/${DM.dmID}/requests">View Requests</a>
                    </li>
                    <li class="nav-item dropdown-center">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Profile
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-dark">
                            <li><a class="dropdown-item" href="/DMs/${DM.dmID}/profile">Manage profile</a></li>
                            <li><a class="dropdown-item" href="/DMs/${DM.dmID}/home">Home</a></li>
                            <li><a class="dropdown-item" href="/DMs/${DM.dmID}/reviews">See reviews</a></li>
                            <li><a class="dropdown-item" href="/home">Log Out</a></li>
                        </ul>
                    </li>
                </ul>
            </ul>
        </div>
    </nav>
    <!-- DM Home Info -->
    <h1 class="text-center mt-3">Welcome, Dungeon Master!</h1>
    <h6 class="text-center mb-3">Select what you would like to do.</h6>
    <div class="container text-center mb-3">
        <div class="row row-cols-md-2">
            <div class="col col-sm">
                <div class="card h-50">
                    <img src="/placeholder2.png" class="card-img-top" alt="Manage Campaigns">
                    <div class="card-body text-center">
                        <a href="/DMs/${DM.dmID}/campaigns" class="btn btn-primary w-75">Manage Campaigns</a>
                    </div>
                </div>
                <div class="card h-50">
                    <img src="/placeholder2.png" class="card-img-top" alt="View Reviews">
                    <div class="card-body">
                        <a href="/high-fidelity-prototype/provider-prototype/playerfeedback.html" class="btn btn-primary w-75">View Player Feedback</a>
                    </div>
                </div>
            </div>
            <div class="col col-md">
                <div class="card h-50">
                    <img src="/placeholder2.png" class="card-img-top" alt="Create Campaign">
                    <div class="card-body">
                        <a href="/DMs/${DM.dmID}/campaigns/createForm" class="btn btn-primary w-75">Create Campaign</a>
                    </div>
                </div>
                <div class="card h-50">
                    <img src="/placeholder2.png" class="card-img-top" alt="View Manuals">
                    <div class="card-body">
                        <a href="/high-fidelity-prototype/tools.html" class="btn btn-primary w-75">View Manuals</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>