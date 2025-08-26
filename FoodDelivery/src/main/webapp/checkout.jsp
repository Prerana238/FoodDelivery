<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
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
            min-height: 100vh;
            color: #212121 ;
        }

        .header {
            text-align: center;
            margin-bottom: 30px;
            padding: 20px;
            background: linear-gradient(135deg, #E53935, #FBC02D);
            border-radius: 15px;
            box-shadow: 0 8px 25px rgba(229, 57, 53, 0.3);
        }

        .header h1 {
            color: #ffffff;
            font-size: 2.2rem;
            font-weight: bold;
        }

        .checkout-card {
            max-width: 720px;
            margin: 0 auto;
            background: #ffffff;
            border-radius: 20px;
            padding: 28px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            border: 3px solid rgba(229, 57, 53, 0.12);
        }

        .checkout-title {
            font-size: 1.4rem;
            font-weight: 800;
            margin-bottom: 16px;
            color: #2d3748;
        }

        .checkout-form label {
            display: block;
            font-weight: 600;
            margin-bottom: 8px;
        }

        .checkout-form textarea,
        .checkout-form select {
            width: 100%;
            padding: 12px 14px;
            border: 2px solid rgba(229, 57, 53, 0.2);
            border-radius: 12px;
            font-size: 1rem;
            background: rgba(255, 255, 255, 0.95);
            transition: all 0.2s ease;
        }

        .checkout-form textarea {
            resize: vertical;
            min-height: 120px;
        }

        .checkout-form textarea:focus,
        .checkout-form select:focus {
            outline: none;
            border-color: #E53935;
            box-shadow: 0 0 0 3px rgba(229, 57, 53, 0.1);
        }

        .form-group {
            margin-bottom: 18px;
        }

        .place-order-btn {
            width: 100%;
            background: linear-gradient(135deg, #E53935, #FBC02D);
            color: #ffffff;
            border: none;
            padding: 14px;
            border-radius: 14px;
            font-size: 1.05rem;
            font-weight: 800;
            cursor: pointer;
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 0.5px;
            box-shadow: 0 6px 20px rgba(229, 57, 53, 0.25);
            margin-top: 6px;
        }

        .place-order-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 26px rgba(229, 57, 53, 0.35);
        }

        @media (max-width: 768px) {
            .checkout-card { padding: 22px; margin: 0 10px; }
            .header h1 { font-size: 1.8rem; }
        }
    </style>
</head>
<body>

    <div class="header">
        <h1>Checkout</h1>
    </div>

    <div class="checkout-card">
        <div class="checkout-title">Complete your order</div>
        <form action="checkout" method="post" class="checkout-form">
            <div class="form-group">
                <label for="address">Delivery Address</label>
                <textarea id="address" name="address" required></textarea>
            </div>

            <div class="form-group">
                <label for="paymentMethod">Payment Mode</label>
                <select name="paymentMethod" id="paymentMethod">
                    <option value="Credit Card">Credit Card</option>
                    <option value="Debit Card">Debit Card</option>
                    <option value="Cash">Cash</option>
                    <option value="UPI">UPI</option>
                </select>
            </div>

            <button type="submit" class="place-order-btn">Place Order</button>
        </form>
    </div>

</body>
</html>
