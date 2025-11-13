<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="form-container">
        <h1>Create Product</h1>
        <form action="products" method="post">
            <div class="form-group">
                <label for="name">Name:</label> <input type="text" id="name"
                    name="name" required />
            </div>

            <div class="form-group">
    <label for="description">Description:</label> 
    <textarea id="description" name="description"></textarea> <!-- 去掉 type="text" -->
</div>

            <div class="form-group">
                <label for="price">Price:</label> <input type="text" id="price"
                    name="price" required step="0.01" min="0" placeholder="e.g., 99.99"/>
            </div>
            <div class="form-group">
                <label for="couponCode">Coupon Code (Optional):</label> <input type="text" id="couponCode"
                    name="couponCode" />
            </div>

            <input type="submit" value="Save Product" class="btn-success" />
            
        </form>
    </div>
</body>
</html>