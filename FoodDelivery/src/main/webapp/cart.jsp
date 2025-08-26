<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.Daoimpl.Cart" %>
<%@ page import="com.tap.modles.CartItem" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart - FoodFlow Restaurants</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #FFF8E1;
            padding-top: 90px;
        }

        /* ✅ Navbar */
        .top-nav {
            position: fixed; top: 0; left: 0; right: 0;
            background: #fff;
            padding: 15px 30px;
            display: flex; justify-content: space-between; align-items: center;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }
        .logo {
            font-size: 1.8rem;
            font-weight: bold;
            color: #E53935;
            text-decoration: none;
        }

        /* ✅ Header Section */
        .header {
            text-align: center;
            margin: 20px auto;
            padding: 20px;
            background: linear-gradient(135deg, #E53935, #FBC02D);
            border-radius: 12px;
            width: 90%;
            max-width: 900px;
            color: #fff;
        }
        .header h1 { font-size: 2rem; margin-bottom: 8px; }

        /* ✅ Cart Container */
        .cart-container {
            max-width: 900px;
            margin: 20px auto;
            background: #fff;
            border-radius: 16px;
            padding: 25px;
            box-shadow: 0 6px 18px rgba(0,0,0,0.08);
        }
        .cart-item {
            display: flex; justify-content: space-between; align-items: center;
            padding: 15px;
            border-bottom: 1px solid #eee;
            flex-wrap: wrap;
        }
        .cart-item:last-child { border-bottom: none; }
        .cart-item-details h3 { font-size: 1.3rem; margin-bottom: 6px; }
        .cart-item-details p { margin: 4px 0; color: #666; }

        /* ✅ Quantity Controls */
        .quantity-controls {
            display: flex; align-items: center; gap: 8px; margin-top: 8px;
        }
        .quantity-btn {
            background: #ff7043; color: white; border: none;
            padding: 6px 12px; font-size: 16px; font-weight: bold;
            border-radius: 6px; cursor: pointer; transition: 0.3s;
        }
        .quantity-btn:hover { background: #f4511e; }

        /* ✅ Remove Button */
        .remove-btn {
            background: #d32f2f; color: white; border: none;
            padding: 10px 16px; font-size: 14px; font-weight: bold;
            border-radius: 8px; cursor: pointer; transition: 0.3s; margin-top: 10px;
        }
        .remove-btn:hover { background: #b71c1c; }

        /* ✅ Total */
        .total {
            font-size: 1.4rem;
            font-weight: bold;
            text-align: right;
            margin: 20px 0;
        }

        /* ✅ Buttons */
        .action-buttons {
            display: flex; gap: 20px; flex-wrap: wrap;
        }
        .action-buttons a, .action-buttons form {
            flex: 1;
        }
        .btn-primary {
            width: 100%; padding: 14px; font-size: 1.1rem; font-weight: bold;
            border: none; border-radius: 10px;
            color: #fff; cursor: pointer; transition: 0.3s;
        }
        .btn-blue { background: #0288d1; }
        .btn-blue:hover { background: #0277bd; }
        .btn-gradient {
            background: linear-gradient(135deg, #E53935, #FBC02D);
        }
        .btn-gradient:hover { transform: scale(1.03); }

        /* ✅ Empty Cart */
        .empty-cart {
            text-align: center;
            background: #fff;
            padding: 30px;
            margin: 40px auto;
            width: 90%;
            max-width: 500px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        .empty-cart h3 { font-size: 24px; margin-bottom: 10px; }
        .empty-cart p { margin-bottom: 20px; color: #666; }
        .continue-btn {
            display: inline-block; background: #0288d1;
            color: #fff; font-size: 16px; font-weight: bold;
            padding: 12px 24px; text-decoration: none; border-radius: 8px;
            transition: background 0.3s ease;
        }
        .continue-btn:hover { background: #0277bd; }

        /* ✅ Responsive */
        @media (max-width: 768px) {
            .cart-item { flex-direction: column; text-align: center; }
            .quantity-controls { justify-content: center; }
            .action-buttons { flex-direction: column; }
        }
    </style>
</head>
<body>

    <!-- ✅ Navbar -->
    <div class="top-nav">
        <a href="Restaurant1.jsp" class="logo">🍽️ FoodFlow</a>
    </div>

    <!-- ✅ Header -->
    <div class="header">
        <h1>🛒 Your Cart</h1>
        <p>Review your delicious selections</p>
    </div>

    <!-- ✅ Cart Container -->
    <div class="cart-container">
        <%
            Cart cart = (Cart) session.getAttribute("cart"); 
            Integer restaurantId = (Integer) session.getAttribute("restaurantId");

            if(cart != null && !cart.getItems().isEmpty()) {
                int grandTotal = 0;
                for(CartItem item : cart.getItems().values()) {
                    grandTotal += item.getTotalPrice();
        %>
            <!-- ✅ Cart Item -->
            <div class="cart-item">
                <div class="cart-item-details">
                    <h3><%= item.getName() %></h3>
                    <p>Price: ₹<%= item.getPrice() %></p>
                    <p>Total: ₹<%= item.getTotalPrice() %></p>

                    <div class="quantity-controls">
                        <form action="cart" method="post" style="display:inline">
                            <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="quantity" value="<%= item.getQuantity()-1 %>">
                            <button type="submit" class="quantity-btn">-</button>
                        </form>

                        <p><%= item.getQuantity() %></p>

                        <form action="cart" method="post" style="display:inline">
                            <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="quantity" value="<%= item.getQuantity()+1 %>">
                            <button type="submit" class="quantity-btn">+</button>
                        </form>
                    </div>
                </div>

                <!-- Remove Button -->
                <form action="cart" method="post">
                    <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <input type="hidden" name="action" value="remove">
                    <button type="submit" class="remove-btn">Remove</button>
                </form>
            </div>
        <% } %>

            <!-- ✅ Total and Buttons -->
            <div class="total">Grand Total: ₹ <%= grandTotal %></div>

            <div class="action-buttons">
                <a href="menu?restaurantId=<%= restaurantId %>" style="text-decoration:none;">
                    <button type="button" class="btn-primary btn-blue">Add More Items</button>
                </a>
                <form action="checkout.jsp" method="post">
                    <input type="submit" value="Proceed to Checkout" class="btn-primary btn-gradient">
                </form>
            </div>

        <% } else { %>
            <!-- ✅ Empty Cart -->
            <div class="empty-cart">
                <h3>Your cart is empty!</h3>
                <p>Looks like you haven't added any delicious items yet!</p>
                <a href="menu?restaurantId=<%= restaurantId %>" class="continue-btn">Continue Shopping</a>
            </div>
        <% } %>
    </div>

</body>
</html>
