<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="sectionContainerCenter" style="height:100%;">
	<div>
		<div class="msg">${msg}</div>
		<form class="frm" id="frm" action="/user/loginProc" method="post">
			<div><input type="text" name="user_id" placeholder="아이디"></div>
			<div><input type="password" name="user_pw" placeholder="비밀번호"></div>
			<div><button type="submit">로그인</button></div>
		</form>
		<a href="/user/join">회원가입</a>
	</div>
</div>