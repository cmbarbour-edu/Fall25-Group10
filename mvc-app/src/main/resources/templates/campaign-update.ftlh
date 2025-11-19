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
    <!-- Create a campaign -->
    <div class="container justify-content-center" >
        <form id="create-campaign" action="/DMs/${DM.dmID}/campaigns/${campaign.campaignID}/update" method="post">
            <div class="mb-3 px-1">
                <label for="Campaign name" class="form-label px-1">Title</label>
                <input type="text" class="form-control" id="title" name="title" value="${campaign.title}" placeholder="Secrets of the Never-ending Gardens" required>
            </div>
            <div class="mb-3 px-1">
                <label for="Campaign edition" class="form-label px-1">Edition</label>
                <select class="form-select" id="edition" name="edition" aria-label="Default campaign edition" required>
                    <option value="" selected disabled>Please select edition</option>
                    <option value="D&D 5e">D&D 5e</option>
                </select>
            </div>
            <div class="mb-3 px-1">
                <label for="Short campaign description" class="form-label px-1">Short Campaign Description</label>
                <textarea class="form-control" id="shortDescription" name="shortDescription" rows="5" placeholder="Please describe the content of your campaign in a few short sentences. This is what players will look at to determine if they want to join your party, so make it interesting!" required>${campaign.shortDescription} </textarea>
            </div>
            <div class="mb-3 px-1">
                <label for="Extended campaign description" class="form-label px-1">Extended Campaign Description</label>
                <textarea class="form-control" id="description" name="description" rows="5" placeholder="Please describe your campaign in more detail, explaining the content and other important aspects of the campaign such as if it is roleplay or combat focused." required>${campaign.description} </textarea>
            </div>
            <div class="mb-3 px-1">
                <label for="Campaign access" class="form-label px-1">Privacy</label>
                <select class="form-select" id="isPublic" name="isPublic" aria-label="Default privacy" required>
                    <option value="" selected disabled>Please select privacy options</option>
                    <option value="true">Public</option>
                    <option value="false">Private</option>
                </select>
            </div>
            <div class="container py-4">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href= "/DMs/${DM.dmID}/campaigns/${campaign.campaignID}" class="btn btn-outline-danger">Cancel</a>
                <a href="/DMs/${DM.dmID}/campaigns/${campaign.campaignID}/delete" class="btn btn-danger">Delete campaign</a>
            </div>
        </form>
    </div>
</body>
</html>