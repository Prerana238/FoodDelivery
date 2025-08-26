<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.modles.Restaurant"%>
<% List<Restaurant> allrestaurants= (List<Restaurant>)request.getAttribute("restaurants"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home_Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Poppins', sans-serif;
	line-height: 1.6;
	color: #212121;
	background-color: #FFF8E1;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 0 20px;
}

/* Navbar container */
.navbar {
    width: 100%;
    position: fixed;
    top: 0;
    left: 0;
    background: #fff9e6; /* Keep the original background */
    padding: 10px 30px;
    display: flex;
    justify-content: center;
    z-index: 1000;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

/* Align container content */
.nav-container {
    width: 100%;
    max-width: 1200px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

/* Logo style */
.nav-logo span {
    font-size: 22px;
    font-weight: bold;
    color: #ff4d4d;
}

/* Navigation links container */
.nav-links {
    display: flex;
    gap: 15px;
}

/* Navigation links styled as buttons */
.nav-links a {
    text-decoration: none;
    font-weight: bold;
    color: #fff;
    padding: 8px 18px;
    border-radius: 25px;
    background: linear-gradient(90deg, #ff4d4d, #ff9900); /* Hero gradient */
    transition: all 0.3s ease;
    display: flex;
    align-items: center;
    gap: 6px;
    font-size: 14px;
}

/* Hover effect */
.nav-links a:hover {
    background: linear-gradient(90deg, #ff9900, #ff4d4d);
    transform: scale(1.05);
}

/* Special styling for cart icon */
.cart-link {
    padding: 8px 14px;
    font-size: 16px;
}


.cart-count {
	background-color: white;
	color: #E53935;
	font-weight: bold;
	padding: 2px 6px;
	border-radius: 50%;
	font-size: 12px;
	position: absolute;
	top: -8px;
	right: -10px;
}

/* Hero Section */
/* Hero */
        .hero { padding: 120px 0 64px; background: linear-gradient(135deg,#E53935,#FBC02D); color: #212121; }
        .hero-grid { display: grid; grid-template-columns: 1.2fr 1fr; gap: 48px; align-items: center; }
        .hero-title { font-size: clamp(2.2rem, 5vw, 4.2rem); font-weight: 900; line-height: 1.1; color: #fff; }
        .hero-title .highlight { background: linear-gradient(135deg,#FBC02D,#43A047); -webkit-background-clip: text; -webkit-text-fill-color: transparent; background-clip: text; }
        .hero-sub { margin-top: 12px; opacity: 0.9; font-size: 1.05rem; }
        .search { margin-top: 24px; display: flex; gap: 10px; }
        .search input {
            flex: 1; padding: 14px 16px; border-radius: 12px; border: 2px solid rgba(0,0,0,0.08);
            font-size: 1rem; outline: none; transition: 0.2s border-color;
        }
        .search input:focus { border-color: #E53935; box-shadow: 0 0 0 3px rgba(229,57,53,0.08); }
        .search button { padding: 14px 18px; border-radius: 12px; border: 0; font-weight: 800; cursor: pointer; background: #212121; color: #FBC02D; }
        .hero-stats { margin-top: 28px; display: flex; gap: 20px; flex-wrap: wrap; }
        .stat { background: rgba(255,255,255,0.9); border: 2px solid rgba(229,57,53,0.15); padding: 12px 16px; border-radius: 14px; font-weight: 800; }
        .hero-art { position: relative; height: 420px; }
        .hero-float { position: absolute; right: 0; left: auto; background: #fff; border: 2px solid rgba(229,57,53,0.12); border-radius: 20px; padding: 16px 18px; display: flex; gap: 12px; align-items: center; box-shadow: 0 18px 40px rgba(0,0,0,0.12); animation: floaty 6s ease-in-out infinite; }
        .hero-float .float-title { font-weight: 800; color: #2d3748; }
        .hero-float .float-sub { color: #718096; font-size: 0.95rem; }
        .f1 { top: 8px; right: 0; animation-delay: 0s; }
        .f2 { top: 168px; right: 90px; animation-delay: 0.8s; }
        .f3 { bottom: 0; right: 36px; animation-delay: 1.6s; }
        @keyframes floaty { 0%,100%{ transform: translateY(0); } 50%{ transform: translateY(-14px); } }
        .badge { font-size: 0.8rem; padding: 4px 10px; border-radius: 999px; background: #FBC02D; font-weight: 800; display: inline-block; }



.hero {
    position: relative; /* So absolute positioning works */
    padding-bottom: 100px; /* Leave space for button */
}

.order-btn {
    position: absolute;
    bottom: 20px;
    left: 50%;
    transform: translateX(-50%);
    background-color: #fff;
    color: #E53935;
    font-weight: bold;
    padding: 14px 30px;
    font-size: 18px;
    border-radius: 8px;
    text-decoration: none;
    border: none;
    cursor: pointer;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    transition: 0.3s ease;
}

.order-btn:hover {
    background-color: #E53935;
    color: #fff;
}

.nav-username-btn {
    background: linear-gradient(90deg, #ff4e50, #f9d423); /* same gradient as buttons */
    color: #fff; /* white text */
    font-weight: bold;
    font-size: 16px;
    padding: 10px 18px; /* same padding as buttons */
    border-radius: 25px; /* makes it circular */
    display: inline-flex;
    align-items: center;
    justify-content: center;
    margin: 0 10px;
    text-decoration: none;
}



.cta-btn {
	background: white;
	color: #E53935;
	border: none;
	padding: 15px 30px;
	border-radius: 8px;
	font-size: 18px;
	font-weight: 600;
	cursor: pointer;
	transition: all 0.3s ease;
	animation: fadeInUp 1s ease 0.4s both;
}

.cta-btn:hover {
	transform: translateY(-2px);
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
}

/* Featured Restaurant Section */
.featured-restaurant {
	padding: 80px 0;
	background: white;
}

.featured-restaurant h2 {
	text-align: center;
	font-size: 36px;
	font-weight: 600;
	margin-bottom: 50px;
	color: #212121;
}

.restaurant-card {
	max-width: 800px;
	margin: 0 auto;
	background: white;
	border-radius: 16px;
	overflow: hidden;
	box-shadow: 0 8px 30px rgba(0, 0, 0, 0.1);
	transition: all 0.3s ease;
}

.restaurant-card:hover {
	transform: translateY(-5px);
	box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
}

.restaurant-image {
	position: relative;
	width: 100%;
	height: 300px;
	overflow: hidden;
}

.restaurant-image img {
	width: 100%;
	height: 100%;
	object-fit: cover;
	transition: transform 0.3s ease;
}

.restaurant-card:hover .restaurant-image img {
	transform: scale(1.05);
}

.restaurant-badge {
	position: absolute;
	top: 20px;
	right: 20px;
	background: rgba(0, 0, 0, 0.8);
	color: white;
	padding: 8px 12px;
	border-radius: 20px;
	font-size: 14px;
	font-weight: 600;
	display: flex;
	align-items: center;
	gap: 5px;
}

.restaurant-info {
	padding: 30px;
}

.restaurant-header {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
	margin-bottom: 15px;
}

.restaurant-name {
	font-size: 28px;
	font-weight: 700;
	color: #212121;
	margin: 0;
}

.restaurant-rating {
	display: flex;
	align-items: center;
	gap: 5px;
	background: #43A047;
	color: white;
	padding: 6px 12px;
	border-radius: 20px;
	font-size: 14px;
	font-weight: 600;
}

.restaurant-cuisine {
	display: flex;
	align-items: center;
	gap: 8px;
	color: #666;
	font-size: 16px;
	margin-bottom: 15px;
}

.restaurant-cuisine i {
	color: #E53935;
}

.restaurant-address {
	display: flex;
	align-items: flex-start;
	gap: 8px;
	color: #666;
	font-size: 14px;
	margin-bottom: 20px;
	line-height: 1.5;
}

.restaurant-address i {
	color: #E53935;
	margin-top: 2px;
}

.restaurant-details {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 25px;
	padding: 15px 0;
	border-top: 1px solid #f0f0f0;
	border-bottom: 1px solid #f0f0f0;
}

.restaurant-phone, .restaurant-eta {
	display: flex;
	align-items: center;
	gap: 8px;
	color: #666;
	font-size: 14px;
}

.restaurant-phone i, .restaurant-eta i {
	color: #E53935;
}

.restaurant-actions {
	display: flex;
	gap: 15px;
}

.view-menu-btn, .order-now-btn {
	flex: 1;
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 8px;
	padding: 12px 20px;
	border: none;
	border-radius: 8px;
	font-size: 16px;
	font-weight: 600;
	cursor: pointer;
	transition: all 0.3s ease;
}

.rid {
	text-align: center;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<%@ page session="true"%>
	<nav class="navbar">
		<div class="nav-container">

			<!-- Logo and App Name -->
			<div class="nav-logo">
				 <span>🍽️ FoodFlow</span>
			</div>

			<!-- Navigation Links -->
			<div class="nav-links">
				<a href="Restaurant1.jsp"><i class="fas fa-home"></i>Home</a>

				<% 
        String username = (String) session.getAttribute("username"); 
        if (username != null) {
      %>
				<span class="nav-username-btn">Hello <%= username %></span>



				<a href="logout.jsp"><i class="fas fa-sign-out-alt"></i> Logout</a>
				<% } else { %>
				<a href="login.jsp"><i class="fas fa-user"></i> Login</a> <a
					href="Signup.jsp"><i class="fas fa-user-plus"></i> Sign Up</a>
				<% } %>

				<a href="cart.jsp" class="cart-link"> <i
					class="fas fa-shopping-cart"></i>
				</a>
			</div>

		</div>
	</nav>

	<section class="hero">
    <div class="container hero-grid">
        <div>
            <div class="badge">New in your area</div>
            <h1 class="hero-title">Discover Amazing <span class="highlight">Restaurants</span> Near You</h1>
            <p class="hero-sub">Fresh flavors, fast delivery, and exclusive deals. Discover top-rated places and hidden gems.</p>
            
            <div class="hero-stats">
                <div class="stat">25min Avg Delivery</div>
            </div>
        </div>
        <div class="hero-art">
            <div class="hero-float f1"><span style="font-size:26px">🍕</span><div><div class="float-title">Continental Delight</div><div class="float-sub">From Truffles</div></div></div>
            <div class="hero-float f2"><span style="font-size:26px">🍜</span><div><div class="float-title">Spicy Andhra</div><div class="float-sub">From Meghana Foods</div></div></div>
            <div class="hero-float f3"><span style="font-size:26px">🍰</span><div><div class="float-title">Sweet Treats</div><div class="float-sub">From Corner House</div></div></div>
        </div>
    </div>
    
    <!-- Button moved here -->
    <a href="#featured-restaurant" class="order-btn">Order Now</a>
</section>



	<section class="featured-restaurant" id="featured-restaurant">
		<div class="container">
			<h2>Featured Restaurant</h2>
			<div class="restaurant-grid">
				<% for(Restaurant r: allrestaurants){ %>
				<div id="disp">
   <a href="menu?restaurantId=<%= r.getRestaurantId()%>">

       <!-- card content -->
   </a>
</div>
					<div class="restaurant-card">
    <a href="menu?restaurantId=<%= r.getRestaurantId()%>" style="text-decoration:none; color:inherit;">
        <div class="restaurant-image">
            <img src="<%= r.getImagePath() %>" alt="Pizza Palace">
            <div class="restaurant-badge">
                <i class="fas fa-star"></i> <span><%= r.getRating() %> </span>
            </div>
        </div>
        <div class="restaurant-info">
            <div class="restaurant-header">
                <h3 class="restaurant-name"><%=r.getName()%></h3>
            </div>
            <div class="restaurant-cuisine">
                <i class="fas fa-utensils"></i> <span><%=r.getCuisineType()%></span>
            </div>
            <div class="restaurant-address">
                <i class="fas fa-map-marker-alt"></i> <span><%= r.getAddress()%></span>
            </div>
            <div class="restaurant-details">
                <div class="restaurant-phone">
                    <i class="fas fa-phone"></i> <span><%=r.getPhone()%></span>
                </div>
                <div class="restaurant-eta">
                    <i class="fas fa-clock"></i> <span><%= r.getEta() %></span>
                </div>
            </div>
            <div class="rid">
                <span><%= r.getRestaurantId() %></span>
            </div>
        </div>
    </a>
</div>

					</div> <br> <br> <% } %>
				
			</div>
		
	</section>
</body>
</html>