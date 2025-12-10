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
            <a class="navbar-brand" href="/DMs/${DM.dmID}/home">
                <img src="/d20OutlineWhite.PNG" alt="Nat20 Network" width="30" height="auto" class="d-inline-block align-text-top">
            Nat20 Network
            </a>
            <ul class="navbar-nav justify-content-center">
                <ul class="nav justify-content-left">
                    <li class="nav-item align-middle">
                        <a class="nav-link" href="/DMs/${DM.dmID}/rules">Rules</a>
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
    <!-- Campaign Info-->
     <div class="container py-3">
        <div class="row">
            <div class="col mx-auto">
                <div class="card px-1">
                    <h5 class="card-title fw-bold fs-1">${campaign.title}</h5>
                    <h6 class="card-subtitle text-body-secondary fw-bold fs-3">Run by: @${DM.username}</h6>
                    <div class="card-body py-1">
                        <p class="fw-bold fs-5">Short description:</p>
                        <p class="card-text text-body-secondary">${campaign.shortDescription}</p>
                        <p class="fw-bold fs-5 pt-2">Extended description:</p>
                        <p class="card-text text-body-secondary">${campaign.description}</p>
                        <p class="fw-bold fs-5 pt-2">Edition:</p>
                        <p class="card-text text-body-secondary">${campaign.edition}</p>
                        <p class="fw-bold fs-5 pt-2">Privacy:</p>
                        <#if campaign.isPublic>
                            <p class="card-text text-body-secondary">Public</p>
                        <#else>
                            <p class="card-text text-body-secondary">Private</p>
                        </#if>
                        <a class="btn btn-primary" href="/DMs/${DM.dmID}/campaigns/${campaign.campaignID}/updateForm">Edit</a>
                        <a class="btn btn-outline-danger" href="/DMs/${DM.dmID}/campaigns">Back</a>
                        <h5 class="fw-bold fs-5 pt-2">Players</h5>
                        <#list playerList as player>
                            <div class="card py-3 px-2">
                                <h5 class="card-title mb-0 d-flex align-items-center">
                                    @${player.name}
                                    <a
                                        class="btn btn-danger btn-sm ms-2"
                                        href="/DMs/${DM.dmID}/campaigns/${campaign.campaignID}/players/${player.playerID}/remove">
                                        Remove
                                    </a>
                                </h5>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
     </div>
</body>
</html>