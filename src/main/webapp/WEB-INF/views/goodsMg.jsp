<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lessonMg Page</title>
</head>
<body>
	<div id="goodsMg">
		<div id="homeBtn">
			<input type="button" value="HELP" onClick="meMg()"/>
		</div>
		<div id="logOut">
			<input type="button" value="로그아웃" onClick="logOut()" />
		</div>
		<div id="explainGo">
			Goods<br> GoodsManagement 
			<span onClick="insGoods(this)">장비추가</span>
			<span onClick="modGoods(this)">장비수정</span>
		</div>
		<div id="infoGo">
			<label for="searchGoods">장비검색</label>
			 <select>
				<option value="분류" selected>분류</option>
				<option value="장비명">장비명</option>
				<option value="담당자">담당자</option>
			</select>
			 <span>search</span>
			  <input type="text" class="searchGo" />
			  <input type="button" class="goSearchBtn" value="검색" onClick="searchGoods()" />
		</div>
		<div class="category">
            <p class="menuTitle" id="meMg" onClick="goMePage()">회원관리</p>
         </div>
         <div class="category">
            <p class="menuTitle" id="sfMg" onClick="goSfPage()">직원관리</p>
            
         </div>
         <div class="category">
            <p class="menuTitle" id="lessonMg" onClick="goLessonPage()">수업관리</p>
         </div>
         <div class="category">
            <p class="menuTitle" id="goodsMg" onClick="goGoodsPage()">장비관리</p>
         </div>
         <div class="category">
            <p class="menuTitle" id="payMg" onClick="goPayPage()">결제관리</p>
         </div>
	</div>
</body>
</html>