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
                        <a class="nav-link" href="about.html">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="signup.html">Sign up</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.html">Login</a>
                    </li>
                </ul>
            </ul>
        </div>
    </nav>
    <!-- Login Form -->
	<form action="/login" method="post" class="container py-4" style="max-width:720px;">

		<#if error??>
			<div class="alert alert-danger">${error}</div>
		</#if>
		<div class="mb-3">
			<label class="form-label">Email address</label>
			<input type="email" class="form-control" name="email" value="${email!}">
		</div>
		<div class="mb-3">
			<label class="form-label">Password</label>
			<input type="password" class="form-control" name="password">
		</div>

		<!-- hidden role field -->
		<input type="hidden" id="role" name="role">

		<div class="d-grid gap-2 col-4 mx-auto">
			<button type="submit" class="btn btn-primary"
				onclick="document.getElementById('role').value='PLAYER'">
				Sign in as player
			</button>
			<button type="submit" class="btn btn-primary"
				onclick="document.getElementById('role').value='DM'">
				Sign in as DM
			</button>
			<button type="submit" class="btn btn-primary"
				onclick="document.getElementById('role').value='ADMIN'">
				Sign in as system admin
			</button>
		</div>
	</form>
</body>
</html>