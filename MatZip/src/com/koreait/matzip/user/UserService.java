package com.koreait.matzip.user;

import com.koreait.matzip.SecurityUtils;
import com.koreait.matzip.vo.UserVO;

public class UserService {
	private UserDAO dao;
	
	public UserService() {
		dao = new UserDAO();
	}
	
	public int join(UserVO param) {
		String pw = param.getUser_pw();
		String salt = SecurityUtils.generateSalt();
		String encryptPw = SecurityUtils.getEncrypt(pw, salt);
		
		param.setUser_pw(encryptPw);
		param.setSalt(salt);
		
		return dao.join(param);
	}
}
