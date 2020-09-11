package com.koreait.matzip.restaurant;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.koreait.matzip.db.JdbcTemplate;
import com.koreait.matzip.db.JdbcUpdateInterface;
import com.koreait.matzip.vo.RestaurantVO;

public class RestaurantDAO {
	public int insRestaurant(RestaurantVO param) {
		int result = 0;
		
		String sql = " INSERT INTO t_restaurant"
				+ " (nm, addr, lat, lng, cd_category, i_user) "
				+ " VALUES "
				+ " (?, ?, ?, ?, ?, ?) ";
		
		result =  JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {
			
			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getNm());
				ps.setNString(2, param.getAddr());
				ps.setDouble(3, param.getLat());
				ps.setDouble(4, param.getLng());
				ps.setNString(5, param.getCd_category());
				ps.setInt(6, param.getI_user());
			}
		});
		
		return result;
	}
}
