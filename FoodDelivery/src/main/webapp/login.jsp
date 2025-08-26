<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - FoodFlow Restaurants</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 20px;
}


        .top-nav {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }

        .logo {
            font-size: 1.5rem;
            font-weight: bold;
            color: #E53935;
            text-decoration: none;
        }

        .cart-btn {
            background: linear-gradient(135deg, #E53935, #FBC02D);
            color: #212121;
            border: none;
            padding: 10px 20px;
            border-radius: 25px;
            font-weight: bold;
            cursor: pointer;
            text-decoration: none;
            box-shadow: 0 4px 15px rgba(229, 57, 53, 0.3);
            transition: all 0.3s ease;
        }

        .cart-btn:hover {
            transform: scale(1.05);
            box-shadow: 0 6px 20px rgba(229, 57, 53, 0.4);
        }

        .nav-actions {
            display: flex;
            align-items: center;
            gap: 12px;
        }

        .nav-link {
            background: transparent;
            color: #212121;
            border: none;
            padding: 8px 12px;
            border-radius: 12px;
            font-weight: 600;
            cursor: pointer;
            text-decoration: none;
            transition: background 0.2s ease;
        }

        .nav-link:hover {
            background: rgba(229, 57, 53, 0.08);
        }

        .nav-text {
            color: #212121;
            font-weight: 600;
            opacity: 0.9;
        }

        .login-container {
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            border-radius: 25px;
            padding: 40px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
            width: 100%;
            max-width: 400px;
            border: 3px solid rgba(229, 57, 53, 0.2);
        }

        .login-header {
            text-align: center;
            margin-bottom: 30px;
        }

        .login-header h1 {
            color: #212121;
            font-size: 2.2rem;
            font-weight: bold;
            margin-bottom: 10px;
            background: linear-gradient(135deg, #E53935, #FBC02D);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
        }

        .login-header p {
            color: #212121;
            font-size: 1rem;
            opacity: 0.8;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            color: #212121;
            font-weight: 600;
            margin-bottom: 8px;
            font-size: 0.95rem;
        }

        .form-group input {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid rgba(229, 57, 53, 0.2);
            border-radius: 15px;
            font-size: 1rem;
            background: rgba(255, 255, 255, 0.9);
            transition: all 0.3s ease;
        }

        .form-group input:focus {
            outline: none;
            border-color: #E53935;
            box-shadow: 0 0 0 3px rgba(229, 57, 53, 0.1);
        }

        .login-btn {
            width: 100%;
            background: linear-gradient(135deg, #E53935, #FBC02D);
            color: #212121;
            border: none;
            padding: 15px;
            border-radius: 15px;
            font-size: 1.1rem;
            font-weight: bold;
            cursor: pointer;
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 1px;
            box-shadow: 0 6px 20px rgba(229, 57, 53, 0.3);
            margin-bottom: 20px;
        }

        .login-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(229, 57, 53, 0.4);
        }

        .login-btn:active {
            transform: translateY(0);
        }

        .signup-link {
            text-align: center;
            color: #212121;
            font-size: 0.95rem;
        }

        .signup-link a {
            color: #E53935;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .signup-link a:hover {
            color: #FBC02D;
        }

        .forgot-password {
            text-align: center;
            margin-top: 15px;
        }

        .forgot-password a {
            color: #212121;
            text-decoration: none;
            font-size: 0.9rem;
            opacity: 0.8;
            transition: opacity 0.3s ease;
        }

        .forgot-password a:hover {
            opacity: 1;
            color: #E53935;
        }
        
        
       .bg-video {
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    object-fit: cover;   /* keeps proportion and covers screen */
    z-index: -1;
}


        
        .error-msg {
    color: #E53935;
    font-weight: 600;
    text-align: center;
    margin-bottom: 15px;
}
        
.video-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,0.4); /* Dark overlay */
    z-index: -1; /* Same layer as video but still behind content */
}

        @media (max-width: 768px) {
            .login-container {
                padding: 30px 20px;
                margin-top: 80px;
            }
            
            .login-header h1 {
                font-size: 1.8rem;
            }
            
            .top-nav {
                padding: 10px 20px;
            }
           
        }
        
    </style>

</head>
<body>

<video autoplay muted loop playsinline class="bg-video">
    <source src="<%= request.getContextPath() %>/videos/deliveryMan.mp4" type="video/mp4">
</video>

<div class="video-overlay"></div>



<div class="login-container">
    <div class="login-header">
        <h1>Welcome Back</h1>
        <p>Sign in to your account</p>
    </div>

    <% 
        String error = (String) request.getAttribute("error"); 
        if(error != null){ 
    %>
        <p class="error-msg"><%= error %></p>
    <% } %>

    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label for="username">UserName</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>
        </div>

        <button type="submit" class="login-btn">Login</button>
    </form>

    <div class="signup-link">
        Don’t have an account? 
        <a href="Signup.jsp">Sign Up</a>
    </div>

    <div class="forgot-password">
        <a href="#">Forgot Password?</a>
    </div>
</div>
</body>

</html>
