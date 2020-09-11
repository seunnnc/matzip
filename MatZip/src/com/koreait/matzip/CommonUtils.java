package com.koreait.matzip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonUtils {
	public static HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}
	
	public static int parseStrToInt(String str) {
		try {
			Integer.parseInt(str); 
		} catch(Exception e) {}
		return 0;
	}
	
//	public static int getIntParameter(String str, HttpServletRequest request) {
//		return parseStrToInt(request.)
//	}
//	
}
