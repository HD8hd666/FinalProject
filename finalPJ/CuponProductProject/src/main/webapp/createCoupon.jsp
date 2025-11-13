<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Coupon</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="form-container">
        <h1>Create Coupon</h1>
        <form action="coupons" method="post">
            <div class="form-group">
                <label for="couponCode">Coupon Code:</label> <input type="text"
                    id="couponCode" name="couponCode" required />
            </div>

            <div class="form-group">
                <label for="discount">Discount (%):</label> <input type="number"
                    id="discount" name="discount" required step="0.01" min="0"
                    max="100" />
            </div>

            <div class="form-group">
                <label for="expiryDate">Expiry Date:</label> <input type="date"
                    id="expiryDate" name="expiryDate" required />
            </div>

            <input type="hidden" name="action" value="create" />

            <input type="submit" value="Save Coupon" class="btn-primary" />
        </form>
    </div>
</body>
</html>