package com.gep.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gep.cnp.model.Product;
import com.jep.cnp.util.ConnectionUtil;

public class ProductDAO {
	// 修正方法名为 save，修正 SQL 与参数
	public void save(Product product) {
		String sql = "insert into product (name, description, price, coupon_code) values (?, ?, ?, ?)";
		try (Connection connection = ConnectionUtil.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());
			statement.setBigDecimal(3, product.getPrice());
			statement.setString(4, product.getCouponCode());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}