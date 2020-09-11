<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="sectionContainerCenter">
	<div>
		<form id="frm" action="/restaurant/regProc" method="post">
			<div><input type="text" name="nm" placeholder="가계명"></div>
			<div>
				<input type="text" name="addr" placeholder="주소">
				<button type="button" onclick="getLatLng()">좌표가져오기</button>
			</div>
			<input type="hidden1" name="lat" value="0">
			<input type="hidden1" name="lng" value="0">
			<div>
				카테고리 :
				<select name="cd_category">
					<c:forEach items="${categoryList}" var="item">
						<option value="${item.cd}">${item.val}</option>
					</c:forEach>
				</select>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a1d159f218bfc0f213d587f849529f85&libraries=services"></script>
	<script>
		function getLatLng() {
			const geocoder = new kakao.maps.services.Geocoder();
			
			if(addrStr.length < 9) {
				alert('주소를 확인해 주세요')
				frm.addr.focus()
				return
			}
			
			geoCoder.addressSearch(addrStr, )
			
		}
		
		var callback = function(result, status) {
		    if (status === kakao.maps.services.Status.OK) {
		        console.log(result);
		    }
		};

	</script>
</div>

