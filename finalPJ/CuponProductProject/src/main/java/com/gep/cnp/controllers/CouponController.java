package com.gep.cnp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gep.cnp.model.Coupon;
import com.gep.cnp.dao.CouponDAO;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDAO dao = new CouponDAO();

	public CouponController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing action parameter");
			return;
		}
		if (action.equalsIgnoreCase("create")) {
			createCoupon(request, response);
		} else if (action.equalsIgnoreCase("find")) {
			findCoupon(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action: " + action);
		}
	}

	private void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String couponCode = request.getParameter("couponCode");
	    Coupon coupon = dao.findByCode(couponCode);

	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    if (coupon != null) {
	        out.print("<h3>Coupon found:</h3>");
	        out.print("<pre>" + coupon.toString() + "</pre>");
	    } else {
	        out.print("<b>Coupon not found.</b>");
	    }
	    // Use context path so the link works regardless of deployment name
	    out.print("<br/> <a href='" + request.getContextPath() + "/index.html'>Home</a>");
	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String couponCode = request.getParameter("couponCode");
	    String discount = request.getParameter("discount");
	    String expiryDate = request.getParameter("expiryDate");

	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    if (couponCode == null || discount == null || expiryDate == null) {
	        out.print("<b>Missing parameters. Please provide couponCode, discount and expiryDate.</b>");
	        out.print("<br/> <a href='" + request.getContextPath() + "/createCoupon.jsp'>Back</a>");
	        return;
	    }

	    try {
	        Coupon coupon = new Coupon();
	        coupon.setCode(couponCode);
	        coupon.setDiscount(new BigDecimal(discount));
	        coupon.setExpDate(expiryDate);

	        dao.save(coupon);

	        out.print("<b>Coupon created!!</b>");
	        out.print("<br/> <a href='" + request.getContextPath() + "/index.html'>Home</a>");
	    } catch (NumberFormatException ex) {
	        out.print("<b>Invalid discount value.</b>");
	        out.print("<br/> <a href='" + request.getContextPath() + "/createCoupon.jsp'>Back</a>");
	    }
	}
}