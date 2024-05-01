<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="Loginstyle.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.2.0/fonts/remixicon.css" rel="stylesheet" />
</head>
<body>
    <div class="login-container">
        <form action="loginServlet" method="post">
            <h2>Login</h2>
            <div class="input-container">
                <input type="email" placeholder="Email" name="username" required>
            </div>
            <div class="input-container">
                <input type="password" placeholder="Password" name="password" id="password" required>
                <span class="peek" onclick="togglePasswordVisibility()">
                    <i id="peekIcon" class="ri-eye-close-line"></i>
                </span>
            </div>
            <button type="submit">Login</button>
        </form>
        <a href="signup.jsp" class="signup-link">Sign Up</a>
    </div>

    <script>
        function togglePasswordVisibility() {
            var passwordField = document.getElementById("password");
            var peekIcon = document.getElementById("peekIcon");
            if (passwordField.type === "password") {
                passwordField.type = "text";
                peekIcon.classList.add("ri-eye-line");
                peekIcon.classList.remove("ri-eye-close-line");
            } else {
                passwordField.type = "password";
                peekIcon.classList.add("ri-eye-close-line");
                peekIcon.classList.remove("ri-eye-line");
            }
        }
    </script>
</body>
</html>


