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
            <a class="navbar-brand" href="/high-fidelity-prototype/provider-prototype/dmhome.html">
                <img src="/high-fidelity-prototype/images/d20OutlineWhite.PNG" alt="Nat20 Network" width="30" height="auto" class="d-inline-block align-text-top">
            Nat20 Network
            </a>
            <ul class="navbar-nav justify-content-center">
                <ul class="nav justify-content-left">
                    <li class="nav-item align-middle">
                        <a class="nav-link" href="/high-fidelity-prototype/tools.html">Tools</a>
                    </li>
                    <li class="nav-item align-middle">
                        <a class="nav-link" href="campaignrequests.html">View Requests</a>
                    </li>
                    <li class="nav-item dropdown-center">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Profile
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-dark">
                            <li><a class="dropdown-item" href="manageprofile.html">Manage profile</a></li>
                            <li><a class="dropdown-item" href="dmhome.html">Home</a></li>
                            <li><a class="dropdown-item" href="playerfeedback.html">See reviews</a></li>
                            <li><a class="dropdown-item" href="/high-fidelity-prototype/home.html">Log Out</a></li>
                        </ul>
                    </li>
                </ul>
            </ul>
        </div>
    </nav>
    <!-- Profile Info -->
    <div class="container py-4">
        <p class="fw-bold fs-1">Welcome, ${DM.username}</p>
        <form id="update-dm" action="/DMs/${DM.dmID}" method="post">
            <p class="fw-bold fs-3">Username </p>
            <input type="text" id="username" name="username" value="${DM.username}" placeholder="Username" required/>
            <p class="fw-bold fs-3">Email </p>
            <input type="email" id="email" name="email" value="${DM.email}" placeholder="Email" required/>
            <p class="fw-bold fs-3">Password </p>
            <input type="text" id="password" name="password" value="${DM.password}" placeholder="Password" required/> </br>
            <div class="container py-4">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
        <p class="fw-bold fs-3">Campaigns </p>
        <div class="row row-cols-1">
            <div class="col col-sm">
                <#list campaignList as campaign>
                    <div class="card py-3 px-2">
                        <h5 class="card-title">${campaign.title}</h5>
                        <h6 class="card-subtitle mb-2 text-body-secondary">${campaign.edition}</h6>
                        <p class="card-text">${campaign.shortDescription}</p>
                        <a href="/campaigns/${campaign.campaignID}" class="card-link">Details</a>
                    </div>
                </#list>
            </div>
        </div>
        <div class="fs-4 link py-3">
            <a href="playerfeedback.html" class="fs-4 link mx">View player feedback<br></a>
        </div>
        <a href="/DMs/${DM.dmID?c}/delete" class="btn btn-danger">Delete account</a>
    </div>
</body>
</html>