<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - FoodFlow</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), 
                        url('https://images.unsplash.com/photo-1585937421612-70a008356fbe?w=1920&h=1080&fit=crop');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }

        /* Top Navigation */
        .top-nav {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            padding: 15px 40px;
            display: flex;
            justify-content: flex-start; /* Left aligned */
            align-items: center;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }

        .logo {
            font-size: 1.8rem;
            font-weight: bold;
            color: #E53935;
            text-decoration: none;
            letter-spacing: 1px;
        }

        /* Signup Container */
        .signup-container {
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            border-radius: 25px;
            padding: 40px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
            width: 100%;
            max-width: 500px;
            border: 3px solid rgba(229, 57, 53, 0.2);
            margin-top: 80px;
        }

        .signup-header {
            text-align: center;
            margin-bottom: 30px;
        }

        .signup-header h1 {
            color: #212121;
            font-size: 2.2rem;
            font-weight: bold;
            margin-bottom: 10px;
            background: linear-gradient(135deg, #E53935, #FBC02D);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
        }

        .signup-header p {
            color: #212121;
            font-size: 1rem;
            opacity: 0.8;
        }

        .form-row {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group.full-width {
            grid-column: 1 / -1;
        }

        .form-group label {
            display: block;
            color: #212121;
            font-weight: 600;
            margin-bottom: 8px;
            font-size: 0.95rem;
        }

        .form-group input,
        .form-group select,
        .form-group textarea {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid rgba(229, 57, 53, 0.2);
            border-radius: 15px;
            font-size: 1rem;
            background: rgba(255, 255, 255, 0.9);
            transition: all 0.3s ease;
            font-family: inherit;
        }

        .form-group input:focus,
        .form-group select:focus,
        .form-group textarea:focus {
            outline: none;
            border-color: #E53935;
            box-shadow: 0 0 0 3px rgba(229, 57, 53, 0.1);
        }

        .form-group textarea {
            resize: vertical;
            min-height: 80px;
        }

        .signup-btn {
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

        .signup-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(229, 57, 53, 0.4);
        }

        .signup-btn:active {
            transform: translateY(0);
        }

        .login-link {
            text-align: center;
            color: #212121;
            font-size: 0.95rem;
        }

        .login-link a {
            color: #E53935;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .login-link a:hover {
            color: #FBC02D;
        }

        .required {
            color: #E53935;
        }

        @media (max-width: 768px) {
            .signup-container {
                padding: 30px 20px;
                margin-top: 100px;
            }
            
            .signup-header h1 {
                font-size: 1.8rem;
            }
            
            .form-row {
                grid-template-columns: 1fr;
                gap: 0;
            }
            
            .top-nav {
                padding: 10px 20px;
            }
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <div class="top-nav">
        <a href="index.html" class="logo">FoodFlow</a>
    </div>

    <div class="signup-container">
        <div class="signup-header">
            <h1>Create Account</h1>
            <p>Join our food community</p>
        </div>

        <form action="SignUpServlet" method="POST">
            <div class="form-row">
                <div class="form-group">
                    <label for="fullName">Full Name <span class="required">*</span></label>
                    <input type="text" id="fullName" name="fullName" required>
                </div>
                <div class="form-group">
                    <label for="username">UserName <span class="required">*</span></label>
                    <input type="text" id="username" name="username" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="email">Email <span class="required">*</span></label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone Number <span class="required">*</span></label>
                    <input type="tel" id="phone" name="phone" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="password">Password <span class="required">*</span></label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password <span class="required">*</span></label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                </div>
            </div>

            <div class="form-group full-width">
                <label for="role">Role <span class="required">*</span></label>
                <select id="role" name="role" required>
                    <option value="">Select your role</option>
                    <option value="customer">Customer</option>
                    <option value="restaurant_manager">Restaurant Manager</option>
                    <option value="delivery_agent">Delivery Agent</option>
                    <option value="superadmin">Super Admin</option>
                </select>
            </div>

            <div class="form-group full-width">
                <label for="address">Address <span class="required">*</span></label>
                <textarea id="address" name="address" placeholder="Enter your full address" required></textarea>
            </div>

            <button type="submit" class="signup-btn">Create Account</button>

            <div class="login-link">
                Already have an account? <a href="login.jsp">Sign In</a>
            </div>
        </form>
    </div>
</body>
</html>
