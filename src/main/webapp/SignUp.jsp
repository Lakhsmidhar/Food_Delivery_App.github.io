<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Page</title>
    <link rel="stylesheet" type="text/css" href="SignUpStyle.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.2.0/fonts/remixicon.css" rel="stylesheet" />
</head>
<body>
    <div class="signup-container">
        <form action="signupServlet" method="post">
            <h2>Sign Up</h2>
            <div class="input-container">
                <input type="email" placeholder="Email" name="email" required>
            </div>
            <div class="input-container">
                <input type="password" placeholder="Password" name="password" id="password" required>
                <span class="peek" onclick="togglePasswordVisibility()">
                    <i id="peekIcon" class="ri-eye-close-line"></i>
                </span>
            </div>
            <div class="input-container">
                <input type="tel" placeholder="Phone Number" name="phone" required>
            </div>
            <div class="input-container">
                <input type="text" placeholder="Address" name="address" required>
            </div>
            <button type="submit">Sign Up</button>
        </form>
    </div>

    <script>
        function togglePasswordVisibility() {
            var passwordField = document.getElementById("password");
            var peekIcon = document.getElementById("peekIcon");
            if (passwordField.type === "password") {
                passwordField.type = "text";
                peekIcon.classList.remove("ri-eye-close-line");
                peekIcon.classList.add("ri-eye-line");
            } else {
                passwordField.type = "password";
                peekIcon.classList.remove("ri-eye-line");
                peekIcon.classList.add("ri-eye-close-line");
            }
        }
    </script>
</body>
</html>
