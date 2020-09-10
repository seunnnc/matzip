package com.koreait.matzip;

import javax.servlet.http.HttpServletRequest;

//잘못된 경로로 갔을때 바로잡아 주기 위해 생성
public class LoginChkInterceptor {
	//null리턴시 아무일 없음
	//문자열 리턴시 sendRedirect
	public static String routerChk(HttpServletRequest request) {
		//로그인 되어 있으면 login, join 접속 안돼야 함

		String[] chkUserUriArr = {"login", "loginProc", "join", "joinProc", "ajaxIdChk"};

		//로그인에 따른 접속 가능여부
		//로그인 되어 있으면 저소헐 수 있는 주소만 여기서 체크, 나머지 전부 로그인이 되어있어야함
		boolean isLogout = SecurityUtils.isLogout(request);
		String[] targetUri = request.getRequestURI().split("/");
		
		if(targetUri.length < 3) {
			return null;
		}
		
		if(isLogout) {	//로그아웃 상태
			if(targetUri[1].equals(ViewRef.URI_USER)) {
				for(String uri : chkUserUriArr) {
					if(uri.equals(targetUri[2])) {
						return null;
					}
				}
			}
			
			return "/user/login";
			
		} else {	//로그인상태
			if(targetUri[1].equals(ViewRef.URI_USER)) {
				for(String uri : chkUserUriArr) {
					if(uri.equals(targetUri[2])) {
						return "/restaurant/restMap";
					}
				}
			}
			
			return null;
		}
	}
}
