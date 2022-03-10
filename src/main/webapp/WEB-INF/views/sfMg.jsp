<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sfMg Page</title>
</head>
<body>
	<div id="sfMg">
		<div id="logOut">
			<div id="homeBtn">
				<input type="button" value="HELP" onClick="meMg()"/>
			</div>
			<input type="button" value="로그아웃" onClick="logOut()" />
		</div>
		<div id="explainSf">
			Staff<br> StaffManagement 
			<span onClick="insSf(this)">직원추가</span>
			<span onClick="modSf(this)">직원수정</span>
		</div>
		<div id="infoSf">
			<label for="searchMember">직원검색</label>
			<select>
				<option value="이름">이름</option>
				<option value="직급" selected>직급</option>
			</select>
				<span>search</span>
				<input type="text" class="searchSf" />
				<input type="button" class="sfSearchBtn" value="검색" onClick="searchSfMg()"/>
		</div>
			<div class="category">
				<p class="menuTitle" id="meMg" onClick="meMg()">회원관리</p>
			</div>
			<div class="category">
				<p class="menuTitle" id="sfMg" onClick="sfMg()">직원관리</p>
			</div>
			<div class="category">
				<p class="menuTitle" id="lessonMg" onClick="lessonMg()">수업관리</p>
			</div>
			<div class="category">
				<p class="menuTitle" id="goodsMg" onClick="goodsMg()">장비관리</p>
			</div>
			<div class="category">
				<p class="menuTitle" id="payMg" onClick="payMg()">결제관리</p>
			</div>
	</div>
</body>
</html>