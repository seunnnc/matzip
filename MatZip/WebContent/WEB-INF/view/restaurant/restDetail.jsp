<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="sectionContainerCenter">
	<div>
		<c:if test="${loginUser.i_user == data.i_user}">
		<div>
			<a href="/restaurant?restMod?i_rest=${data.i_rest}"><button>수정</button></a>
			<button onclick="isDel()">삭제</button>
		</div>
		</c:if>
		<div>
			가게 사진들
		</div>
		<div class="restaurant-detail">
			<div id="detail-header">
				<div class="restaurant_title_wrap">
					<span class="title">
						<h1 class="restaurant_name">${data.nm}</h1>
					</span>
				</div>
				<div class="status_branch_name">
					<span class="cnt_hit">${data.cntHits}</span>
					<span class="cnt_favorite">${data.cntFavorite}</span>
				</div>
			</div>
			<div>
				<table>
					<caption>레스토랑 상세정보</caption>
					<tbody>
						<tr>
							<td>주소</td>
							<td>${data.addr}</td>
						</tr>
						<tr>
							<td>카테고리</td>
							<td>${data.cd_category_nm}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script>
		function isDel(){
			if(confirm('삭제 하시겠습니까?')) {
				location.href='/restaurant/restDetail?i_rest=${data.i_rest}'
			}
		}
		
	</script>
</div>