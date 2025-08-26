<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.invalidate(); // Clear the session
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logged Out</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #FFF8E1;
            padding: 20px;
            padding-top: 100px;
            min-height: 100vh;
            color: #212121;
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

        .logout-wrapper {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .logout-box {
            width: 100%;
            max-width: 520px;
            background: #ffffff;
            border-radius: 20px;
            padding: 32px 28px;
            box-shadow: 0 12px 32px rgba(0,0,0,0.12);
            border: 3px solid rgba(229, 57, 53, 0.12);
            text-align: center;
        }

        .logout-box h2 {
            font-size: 1.8rem;
            font-weight: 800;
            margin-bottom: 10px;
            color: #2d3748;
        }

        .logout-box p {
            font-size: 1rem;
            color: #4a5568;
            margin-bottom: 20px;
        }

        .login-again {
            display: inline-block;
            background: linear-gradient(135deg, #E53935, #FBC02D);
            color: #212121;
            padding: 12px 20px;
            border-radius: 14px;
            font-weight: 800;
            text-decoration: none;
            box-shadow: 0 6px 20px rgba(229, 57, 53, 0.25);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }

        .login-again:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 26px rgba(229, 57, 53, 0.35);
        }

        @media (max-width: 768px) {
            .logout-box { margin: 0 10px; padding: 28px 22px; }
            .logout-box h2 { font-size: 1.5rem; }
        }
    </style>
</head>
<body>
    <div class="top-nav">
        <a href="index.html" class="logo">🍽️ FoodFlow</a>
        <div class="nav-actions">
            
        </div>
    </div>

    <div class="logout-wrapper">
        <div class="logout-box">
            <h2>You've been logged out</h2>
            <p>Thank you for visiting FoodFlow.</p>
            <a class="login-again" href="login.jsp">Login Again</a>
        </div>
    </div>

</body>
</html>


