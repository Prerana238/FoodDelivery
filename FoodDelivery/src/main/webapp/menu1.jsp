<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.tap.modles.Menu"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Menu</title>
    <style>
        /* Reset and Base Styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #fffaf4;
            padding-top: 80px;
        }

        /* Navbar */
        .navbar {
            background: #fff;
            padding: 12px 30px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.08);
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
        }
        .nav-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            max-width: 1200px;
            margin: auto;
        }
        .nav-logo {
            display: flex;
            align-items: center;
            font-size: 26px;
            font-weight: bold;
            color: #FF4C4C;
        }
        .logo-icon {
            margin-right: 8px;
            font-size: 28px;
        }
        .nav-links {
            display: flex;
            gap: 15px;
            align-items: center;
        }
        .nav-links a {
            text-decoration: none;
            color: #fff;
            background: linear-gradient(45deg, #ff4b2b, #ff9248);
            padding: 10px 18px;
            border-radius: 25px;
            font-weight: bold;
            font-size: 14px;
            transition: 0.3s ease;
        }
        .nav-links a:hover {
            transform: scale(1.07);
            box-shadow: 0 4px 12px rgba(255, 75, 43, 0.4);
        }
        .cart-btn {
            width: 44px;
            height: 44px;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 0;
            font-size: 18px;
        }
        .user-greeting {
            color: #333;
            font-weight: 500;
        }

        /* Hero Section */
        .hero-section {
            background: linear-gradient(to right, #ff6a00, #ffcc70);
            color: #fff;
            text-align: center;
            padding: 60px 20px;
            border-radius: 0 0 20px 20px;
        }
        .hero-section h1 {
            font-size: clamp(2rem, 4vw, 3rem);
            font-weight: bold;
            margin-bottom: 10px;
        }
        .hero-section p {
            font-size: clamp(1rem, 2.5vw, 1.3rem);
            opacity: 0.9;
        }

        /* Menu Grid */
        .menu-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
            gap: 25px;
            max-width: 1200px;
            margin: 40px auto;
            padding: 0 20px;
        }
        
        .menu-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 20px;
}
        


        /* Card Styling */
        .menu-item {
            display: flex;
            flex-direction: column;
            background: #fff;
            border-radius: 18px;
            padding: 18px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            position: relative;
        }
        .menu-item:hover {
            transform: translateY(-6px);
            box-shadow: 0 12px 28px rgba(0, 0, 0, 0.12);
        }
        .menu-item::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 4px;
            background: linear-gradient(90deg, #E53935, #FBC02D);
            border-radius: 18px 18px 0 0;
        }
        .menu-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 14px;
            margin-bottom: 15px;
        }
        .menu-name {
            font-size: 1.3rem;
            font-weight: 600;
            margin-bottom: 10px;
            color: #212121;
        }
        .menu-description {
            font-size: 0.95rem;
            color: #555;
            margin-bottom: 12px;
            line-height: 1.4;
            flex-grow: 1;
        }
        .menu-price {
            font-size: 1.2rem;
            font-weight: bold;
            color: #E53935;
            margin-bottom: 15px;
        }

        /* Ensure button stays at bottom */
        .menu-item form {
            margin-top: auto;
        }

        /* Add to Cart Button */
        .add-to-cart-btn {
            width: 100%;
            background: linear-gradient(135deg, #E53935, #FBC02D);
            color: #212121;
            border: none;
            padding: 12px;
            border-radius: 25px;
            font-weight: bold;
            font-size: 0.95rem;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 4px 12px rgba(229, 57, 53, 0.25);
        }
        .add-to-cart-btn:hover {
            transform: scale(1.05);
            box-shadow: 0 6px 18px rgba(229, 57, 53, 0.35);
        }

        /* Responsive */
        @media (max-width: 768px) {
            .hero-section {
                padding: 40px 15px;
            }
            .menu-item {
                padding: 15px;
            }
            .nav-links {
                flex-wrap: wrap;
                gap: 10px;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>

<nav class="navbar">
    <div class="nav-container">
        <div class="nav-logo">
            <span class="logo-icon">🍽️</span>
            <span class="logo-text">FoodFlow</span>
        </div>
        <div class="nav-links">
            <a href="Restaurant1.jsp"><i class="fas fa-home"></i> Home</a>
            <% String username = (String) session.getAttribute("username");
               if (username != null) { %>
                <span class="user-greeting">Hello, <%= username %></span>
                <a href="logout.jsp"><i class="fas fa-sign-out-alt"></i> Logout</a>
            <% } else { %>
                <a href="login.jsp"><i class="fas fa-user"></i> Login</a>
                <a href="Signup.jsp"><i class="fas fa-user-plus"></i> Sign Up</a>
            <% } %>
            <a href="cart.jsp" class="cart-btn"><i class="fas fa-shopping-cart"></i></a>
        </div>
    </div>
</nav>

<section class="hero-section">
    <h1>🍽 Our Delicious Menu</h1>
    <p>Authentic Flavors, Fresh Ingredients</p>
</section>

<div class="menu-grid">
    <% List<Menu> menuList =(List<Menu>)request.getAttribute("menus");
       for(Menu m : menuList){ %>
        <div class="menu-item">
            <img src="<%= request.getContextPath() + "/" + m.getImagePath() %>" alt="<%= m.getItemName() %>" class="menu-image">
            <h3 class="menu-name"><%= m.getItemName() %></h3>
            <p class="menu-description"><%= m.getDescription() %></p>
            <div class="menu-price">₹<%= m.getPrice() %></div>
            <form action="cart" method="post">
                <input type="hidden" name="restaurantId" value="<%= request.getParameter("restaurantId") %>">
                <input type="hidden" name="itemId" value="<%= m.getMenuId() %>">
                <input type="hidden" name="quantity" value="1" min="1">
                <input type="hidden" name="action" value="add">
                <button type="submit" class="add-to-cart-btn">Add to Cart</button>
            </form>
        </div>
    <% } %>
</div>

</body>
</html>
