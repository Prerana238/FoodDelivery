<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Placed</title>
    <style>
        /* Reset styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body, html {
            height: 100%;
            font-family: 'Segoe UI', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            overflow: hidden;
            color: white;
        }

        /* Background video */
        .video-container {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
            z-index: -2;
        }

        .video-container video {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        /* Dark overlay */
        .overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.35); /* lighter for better brightness */
            z-index: -1;
        }

        /* Main content */
        .content {
            position: relative;
            z-index: 1;
            animation: fadeIn 1.5s ease-in-out;
        }

        /* Gradient animated text: Dark orange -> Bright yellow */
        .content h1 {
            font-size: 64px;
            font-weight: bold;
            background: linear-gradient(90deg, #ff4500, #ff8c00, #ffd700);
            background-size: 300% 300%;
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            animation: gradientMove 4s ease infinite, fadeInUp 1.5s ease;
            margin-bottom: 20px;
        }

        .content p {
            font-size: 22px;
            margin-bottom: 40px;
            color: #fff; /* Removed grey tint for better brightness */
            animation: fadeInUp 2s ease;
        }

        /* Glass button */
        .btn {
            display: inline-block;
            padding: 14px 32px;
            background: rgba(255, 255, 255, 0.2);
            color: #fff;
            border-radius: 30px;
            font-size: 20px;
            font-weight: bold;
            text-decoration: none;
            border: 2px solid rgba(255, 255, 255, 0.3);
            backdrop-filter: blur(8px);
            transition: all 0.3s ease;
            animation: fadeInUp 2.5s ease;
        }

        .btn:hover {
            background: rgba(255, 255, 255, 0.4);
            color: #ff8c00; /* Orange hover */
            border-color: #fff;
        }

        /* Animations */
        @keyframes gradientMove {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }

        @keyframes fadeInUp {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
    <!-- Background video -->
    <div class="video-container">
        <video autoplay muted loop>
            <source src="<%=request.getContextPath()%>/videos/deliveryMan.mp4" type="video/mp4">
        </video>
    </div>

    <!-- Dark overlay -->
    <div class="overlay"></div>

    <!-- Content -->
    <div class="content">
        <h1>Your Order has been placed :)</h1>
        <p>Thank you for choosing us! Your delicious food is on its way.</p>
        <a href="Home" class="btn">Go Back to Home</a>
    </div>
</body>
</html>
