<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoodsMg Page</title>
<script src="res/js/resource.js"></script>
<script src="res/js/YGoods.js"></script>
<style>
.gModal {
	display: none;
	background-color: gray;
	background: rgba(0, 0, 0, 0.4);
	position: absolute;
	width: 100%;
	min-height: 100%;
	left: 0;
	top: 0;
	text-align:center;
}

.goodsLog {border :2px solid white;
	border-radius: 25px;
	background-color: #ffffff;
	position: absolute;
	top: 50%;
	left: 50%;
	width: 90%;
	height: 450px;
	transform: translate(-50%,-50%);
}
</style>
</head>
<body onload="goodsMg('${ctCode}')">
	<div id="goodsMg">
		<div id="homeBtn">
			<input type="button" value="HELP" onClick="meMg()" />
		</div>
		<div id="logOut">
			<input type="button" value="로그아웃" onClick="logOut()" />
		</div>
		<div id="explainGo">
			Goods<br> GoodsManagement <span onClick="insGoods('${ctCode}')">장비추가</span>
			<span onClick="modGoods('${ctCode}')">장비수정</span>
		</div>
		<div id="infoGo">
			<label for="searchGoods" >장비검색</label>
			 <select id="searchCategory">
				<option value="eqCaName" selected>분류</option>
				<option value="eqName">장비명</option>
				<option value="sfName">담당자</option>
			</select>
			<span>search</span>
			<input type="text" class="searchGo" />
			<input type="button" class="goSearchBtn" value="검색" onClick="searchGoods('${ctCode}')" />
		</div>
		<div id="ajax"></div>
		<div class="category">
			<p class="menuTitle" id="meMg" onClick="goMePage('${ctCode}')">회원관리</p>
		</div>
		<div class="category">
			<p class="menuTitle" id="sfMg" onClick="goSfPage('${ctCode}')">직원관리</p>

		</div>
		<div class="category">
			<p class="menuTitle" id="lessonMg" onClick="goLessonPage('${ctCode}')">수업관리</p>
		</div>
		<div class="category">
			<p class="menuTitle" id="goodsMg" onClick="goGoodsPage('${ctCode}')">장비관리</p>
		</div>
		<div class="category">
			<p class="menuTitle" id="payMg" onClick="goPayPage('${ctCode}')">결제관리</p>
		</div>
	</div>
	<div class="gModal"id="gModal">
		<div class="goodsLog">
			<div class="gcontent">
				<div class="gheader">
					<h4 class="mtitle" id="mdtitle"></h4>
				</div>
				<div class="mbody" id="mdbody">
					
				</div>
				<div class="mbody"id="mbody">
					<input type="button" class="mbtn" onclick="closeModal()"value="닫기"/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>