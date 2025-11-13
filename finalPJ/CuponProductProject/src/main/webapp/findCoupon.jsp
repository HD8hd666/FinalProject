<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Coupon</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="form-container" style="max-width: 350px;">
        <h1>Find Coupon</h1>
        <form action="coupons" method="post">
            <div class="form-group">
                <label for="couponCode">Enter Coupon Code:</label> <input
                    type="text" id="couponCode" name="couponCode" required
                    placeholder="e.g., Discount1111/30%" />
            </div>

            <input type="hidden" name="action" value="find" />
            <input type="submit" value="Search" class="btn-warning" />
        </form>
    </div>
</body>
</html>