package com.gep.cnp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gep.cnp.dao.ProductDAO;
import com.gep.cnp.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao = new ProductDAO();

	public ProductController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createProduct(request, response);
	}

	private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String name = request.getParameter("name");
	    String description = request.getParameter("description");
	    String priceStr = request.getParameter("price");
	    String couponCode = request.getParameter("couponCode");

	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    if (name == null || priceStr == null) {
	        out.print("<b>Missing required parameters (name, price).</b>");
	        out.print("<br/> <a href='" + request.getContextPath() + "/createProduct.jsp'>Back</a>");
	        return;
	    }

	    try {
	        Product product = new Product();
	        product.setName(name);
	        product.setDescription(description);
	        product.setPrice(new BigDecimal(priceStr));
	        product.setCouponCode(couponCode);

	        dao.save(product);

	        out.print("<b>Product created!!</b>");
	        out.print("<br/> <a href='" + request.getContextPath() + "/index.html'>Home</a>");
	    } catch (NumberFormatException ex) {
	        out.print("<b>Invalid price value.</b>");
	        out.print("<br/> <a href='" + request.getContextPath() + "/createProduct.jsp'>Back</a>");
	    }
	}
}