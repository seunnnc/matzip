<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/res/css/common.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
<title>${title}</title>
</head>
<body>
	<div id="container">
		<header>
			<div id="headerLeft">
				<div class="containerPImg mL10" >
					<c:choose>
						<c:when test="${loginUser.profile_img != null}">
							<img class="pImg" src="/res/img/user/${loginUSer.i_user}/${loginUser.profile_img}">
						</c:when>
						<c:otherwise>
							<img class="pImg" src="/res/img/default_profile_img.png">
						</c:otherwise>
					</c:choose>
				</div>
				<div class="mL10"><span id="user_nm">${loginUser.nm}</span>님 환영합니다 </div>
				<div class="mL15" id="headerLogout"><a href="/user/logout">로그아웃</a></div>
			</div>
			<div id="headerRight">
				<a href="/restaurant/restMap">
					<i class="fas fa-map-marked-alt"></i>
				</a>
				<a class="mL20" href="/restaurant/restReg">
					<i class="fas fa-plus"></i>
				</a>
				<a class="mL20" href="/user/restFavorite">
					<i class="fas fa-bookmark"></i>
				</a>
			</div>
		</header>
		<section>
			<jsp:include page="/WEB-INF/view/${view}.jsp"></jsp:include>
		</section>
		<footer>
			회사정보
		</footer>
	</div>
</body>
</html>