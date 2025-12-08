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
    <!-- Reviews for the DM -->
    <div class="container py-4">
        <p class="fw-bold fs-1">Player Feedback</p>
        <div class="row row-cols-1">
            <div class="col col-sm">
                <#list reviewList as review>
                    <div class="card py-3 px-2">
                        <h5 class="card-title mx-1">Player: <a href="/DMs/${DM.dmID}/players/${review.player.playerID}/stats">@${review.player.name} </a></h5>
                        <h6 class="card-subtitle mx-1 mb-2 ">Campaign: <a href="/DMs/${DM.dmID}/campaigns/${review.campaign.campaignID}">${review.campaign.title} </a></h6>
                        <p class="card-text mx-1 mb-1">Campaign Rating: ${review.campaignRating} </p>
                        <p class="card-text mx-1 mb-1">DM Rating: ${review.dmRating} </p>
                        <p class="card-text mx-1 mb-1">Overall Rating: ${review.overallRating} </p>
                        <p class="card-text mx-1 mb-1 text-body-secondary">${review.comment} </p>
                        <#if (review.dmResponse?has_content)>
                            <div class="card mt-3">
                                <div class="card-body">
                                    <h6 class="card-subtitle mb-2 text-body-secondary">DM Response:</h6>
                                    <p class="card-text text-body-secondary">${review.dmResponse}</p>
                                </div>
                            </div>
                        <#else>
                            <form action="/DMs/${DM.dmID}/reviews/${review.id}/dmresponse" method="post">
                                <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#replyBox-${review.id}" aria-expanded="false" aria-controls="replyBox">Reply</button>
                                <div class="collapse mt-3" id="replyBox-${review.id}">
                                    <div class="card card-body">
                                        <textarea name="dmResponse" class="form-control mb-2" rows="3" placeholder="Write your reply..."></textarea>
                                        <div class="container py-4">
                                            <button type="submit" class="btn btn-primary">Send</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </#if>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</body>
</html>