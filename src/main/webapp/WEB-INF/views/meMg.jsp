<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meMg Page</title>
<script src="res/js/resource.js"></script>
</head>
<body>
	<div id="meMg">
		<div id="homeBtn">
			<input type="button" value="HELP" onClick="meMg()"/>
		</div>
		<div id="logOut">
			<input type="button" value="로그아웃" onClick="logOut()" />
		</div>
		<div id="explainMe">
		Member<br> MemberManagement
		</div>
		<div id="infoMe">
			<label for="searchMember">회원검색</label>
				<select>
					<option value="이름">이름</option>
					<option value="연락처" selected>연락처</option>
				</select>
			<label for="CaMember">회원유형</label>
				<select>
					<option value="회원유형" selected>회원유형</option>
					<option value="일반">일반</option>
					<option value="PT">PT</option>
					<option value="요가">요가</option>
					<option value="필라테스">필라테스</option>
					<option value="줌바댄스">줌바댄스</option>
					<option value="스피닝">스피닝</option>
				</select>
			<span>search</span>
				<input type="text" class="searchMe" />
				<input type="button" class="meSearchBtn" value="검색" onClick="searchMeMg()"/>
				<input type="button" class="addMember" value="등록" onClick="getCaList(this)"/>
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