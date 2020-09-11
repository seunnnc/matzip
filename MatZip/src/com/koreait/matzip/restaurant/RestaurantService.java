package com.koreait.matzip.restaurant;

import com.koreait.matzip.vo.RestaurantVO;

public class RestaurantService {
	private RestaurantDAO dao;
	
	public RestaurantService() {
		dao = new RestaurantDAO();
	}
	
	public int restReg(RestaurantVO param) {
		
		return dao.insRestaurant(param);
	}
}
