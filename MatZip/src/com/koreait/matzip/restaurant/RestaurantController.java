package com.koreait.matzip.restaurant;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.CommonDAO;
import com.koreait.matzip.CommonUtils;
import com.koreait.matzip.Const;
import com.koreait.matzip.FileUtils;
import com.koreait.matzip.SecurityUtils;
import com.koreait.matzip.ViewRef;
import com.koreait.matzip.vo.RestaurantRecommendMenuVO;
import com.koreait.matzip.vo.RestaurantVO;
import com.koreait.matzip.vo.UserVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RestaurantController {
	private RestaurantService service;
	
	public RestaurantController() {
		service = new RestaurantService();
	}

	public String restMap(HttpServletRequest request) {
		request.setAttribute(Const.TITLE, "map");
		request.setAttribute(Const.VIEW, "restaurant/restMap");
		return ViewRef.TEMP_MENUTEMP;
	}
	
	public String restReg(HttpServletRequest request) {
		final int I_M = 1;	//카테고리 코드
		request.setAttribute("categoryList", CommonDAO.selCodeList(I_M));
		
		request.setAttribute(Const.TITLE, "map");
		request.setAttribute(Const.VIEW, "restaurant/restReg");
		return ViewRef.TEMP_MENUTEMP;
	}
	
	public String restRegProc(HttpServletRequest request) {
		String nm = request.getParameter("nm");
		String addr = request.getParameter("addr");
		String strLat = request.getParameter("lat");
		String strLng = request.getParameter("lng");
		String strCd_category = request.getParameter("cd_category");
		double lat = Double.parseDouble(strLat);
		double lng = Double.parseDouble(strLng);
		int cd_category = CommonUtils.parseStringToInt(strCd_category);
		UserVO vo = SecurityUtils.getLoginUser(request);
		
		RestaurantVO param = new RestaurantVO();
		param.setNm(nm);
		param.setAddr(addr);
		param.setLat(lat);
		param.setLng(lng);
		param.setCd_category(cd_category);
		param.setI_user(vo.getI_user());
		
		int result = service.restReg(param);
		
		return "redirect:/restaurant/restMap";
	}
	
	public String ajaxGetList(HttpServletRequest request) {
		return "ajax:" + service.getRestList();
	}
	
	public String restDetail(HttpServletRequest request) {
		int i_rest = CommonUtils.getIntParameter("i_rest", request);
		
		RestaurantVO param = new RestaurantVO();
		param.setI_rest(i_rest);
		
		request.setAttribute("css", new String[]{"restaurant"});
		request.setAttribute("recommendMenuList", service.getRecommendMenuList(i_rest));
		request.setAttribute("data", service.getRest(param));
		request.setAttribute(Const.TITLE, "디테일");
		request.setAttribute(Const.VIEW, "restaurant/restDetail");
		return ViewRef.TEMP_MENUTEMP;
	}
	
	public String addRecMenusProc(HttpServletRequest request) {
		int i_rest = service.addRecMenus(request);
		
		return "redirect:/restaurant/restDetail?i_rest=" + i_rest;
	}
	
	public String ajaxDelRecMenu(HttpServletRequest request) {
		int i_rest = CommonUtils.getIntParameter("i_rest", request);
		int seq = CommonUtils.getIntParameter("seq", request);
		
		RestaurantRecommendMenuVO param = new RestaurantRecommendMenuVO();
		param.setI_rest(i_rest);
		param.setSeq(seq);
		
		int result = service.delRecMenu(param);
		
		return "ajax:" + result;
	}
	
}
