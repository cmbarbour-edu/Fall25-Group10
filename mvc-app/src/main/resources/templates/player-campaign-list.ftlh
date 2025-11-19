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
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar bg-dark boarder-bottom border-3 border-secondary" data-bs-theme="dark">
        <div class="container-fluid" position="relative">
            <a class="navbar-brand" href="/players/${player.playerID}/home">
                <img src="/d20OutlineWhite.PNG" alt="Nat20 Network" width="30" height="auto" class="d-inline-block align-text-top">
            Nat20 Network
            </a>
            <ul class="navbar-nav justify-content-center">
                <ul class="nav justify-content-left">
                    <li class="nav-item align-middle">
                        <a class="nav-link" href="">Tools</a>
                    </li>
                    <li class="nav-item align-middle">
                        <a class="nav-link" href="/DMs/${DM.dmID}/requests">View Requests</a>
                    </li>
                    <li class="nav-item dropdown-center">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Profile
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-dark">
                            <li><a class="dropdown-item" href="/players/${player.playerID}/profile">Manage profile</a></li>
                            <li><a class="dropdown-item" href="/players/${player.playerID}/home">Home</a></li>
                            <li><a class="dropdown-item" href="/players/${player.playerID}/reviews">Write reviews</a></li>
                            <li><a class="dropdown-item" href="/home">Log Out</a></li>
                        </ul>
                    </li>
                </ul>
            </ul>
        </div>
    </nav>
    <!-- Campaign Info -->
    <div class="container py-4">
        <p class="fw-bold fs-1">Your campaigns</p>
        <div class="row row-cols-1">
            <div class="col col-sm">
                <#list campaignList as campaign>
                    <div class="card py-3 px-2">
                        <h3 class="card-title">${campaign.title}</h3>
                        <h4 class="card-subtitle mb-2 text-body-secondary">${campaign.edition}</h4>
                        <p class="card-text text-body-secondary">${campaign.description}</p>
                        <#if campaign.isPublic>
                            <p class="card-text text-body-secondary">Public</p>
                        <#else>
                            <p class="card-text text-body-secondary">Private</p>
                        </#if>
                        <a href="/players/${player.playerID}/campaigns/${campaign.campaignID}" class="card-link">Details</a>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</body>
</html>