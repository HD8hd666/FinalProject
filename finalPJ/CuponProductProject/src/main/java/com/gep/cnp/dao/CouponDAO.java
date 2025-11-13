package com.gep.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gep.cnp.model.Coupon;
import com.jep.cnp.util.ConnectionUtil;

public class CouponDAO {
	
	public void save(Coupon coupon) {
		String sql = "insert into coupon (code,discount,exp_date) values(?,?,?)";
		try (Connection connection = ConnectionUtil.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 修正方法名为 findByCode，返回 null 当未找到
	public Coupon findByCode(String code) {
		String sql = "select id, code, discount, exp_date from coupon where code=?";
		try (Connection connection = ConnectionUtil.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, code);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Coupon coupon = new Coupon();
					coupon.setId(resultSet.getInt("id"));
					coupon.setCode(resultSet.getString("code"));
					coupon.setDiscount(resultSet.getBigDecimal("discount"));
					coupon.setExpDate(resultSet.getString("exp_date"));
					return coupon;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}