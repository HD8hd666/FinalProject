package com.gep.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gep.cnp.model.Product;
import com.jep.cnp.util.ConnectionUtil;

public class ProductDAO {
	public void sava(Product product) {
	Connection connection = ConnectionUtil.getConnection();
	try {
		PreparedStatement statement = connection.prepareStatement("insert into coupon (code,discount,exp_date) values(?,?,?)");
		statement.setString(1,product.getName());
		statement.setString(2, product.getDescription());
		statement.setBigDecimal(3, product.getPrice());
		statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
