<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" type="text/css" href="res/css/home.css" />
<script  src="res/js/resource.js" src="res/js/bon.js"    ></script>



<style>
.container {
	display: none;
	background-color: gray;
	background: rgba(0, 0, 0, 0.4);
	position: absolute;
	width: 100%;
	min-height: 100%;
	left: 0;
	top: 0;
	text-align: center;
	font-size: 17pt;
	font-weight: 700;
	z-index: 100;
}

.containerSF {
	display: none;
	background-color: gray;
	background: rgba(0, 0, 0, 0.4);
	position: absolute;
	width: 100%;
	min-height: 100%;
	left: 0;
	top: 0;
	text-align: center;
	font-size: 17pt;
	font-weight: 700;
	z-index: 100;
}

.mdialog {
	border: 2px solid white;
	border-radius: 25px;
	background-color: #ffffff;
	position: absolute;
	top: 50%;
	left: 50%;
	width: 70%;
	height: 750px;
	transform: translate(-50%, -50%);
	font-size: 17pt;
	font-weight: 700;
	z-index: 101;
}
</style>
</head>

<body onLoad="initPage()">

	<div class=circle></div>
	<div class=circle2></div>
	<div class=circle3></div>
	<div class=circle4></div>
	<div class=crcle5></div>
	<div class=circle6></div>

	<div class="logo">
		<div class="zero">
			<br>
			<div class="one"></div>
		</div>
		<div class="hp">
			H E L P
			<div id="plan">Health Plan</div>
		</div>
	</div>

	<div class="underLine"></div>
	<div class="text">
		Do your<br>best work
	</div>

	<div class="somebody">Made by :: SOMEBODY</div>
	<div class="logIn">
		<input class="log" type="button" value="Log In"
			onClick="meLogInModal()" />
	</div>


	<!-- 회원 로그인 모달 -->
	<form name="dynamicFormdata" action="meLogin" method="post">
		<div class="container" id="container">
			<div class="mdialog">
				<br> <br> <br> <br> <br>

				<!-- 모달 바디 -->
				<div class="mbody" id="mbody">
					<br>
					<div>ID</div>
					<input type='text' class='id' name='meCode'
						placeholder='아이디를 입력하세요' /> <br> <br>
					<div>Password</div>

					<input type='password' class='pw' name='mePw' /><br> <br>
					<input class="login" type="button" value="로그인" onClick="meLogIn()" /><br>
					<br> <input class="login" type="button" value="매장로그인"
						onClick="ctLogInModal()" />
				</div>
				<!-- 모달 푸터 <div id = "list">${list} </div> -->
				<div class="mfooter">
					<input type="button" class="mbtn" value="비밀번호변경"
						onClick="sendEmailForm()" /> <input type="button" class="mbtn"
						value="센터가입" onClick="goJoinPage()" />
						
				</div>

			</div>
		</div>
	</form>

	<!-- 센터 로그인 모달 -->
	<form name="dynamicFormdata2" action="ctLogin" method="post">
		<div class="containerSF" id="containerSF">
			<div class="mdialog">
				<div class="mcontent">
					<br> <br> <br> <br> <br>

				</div>

				<div class="mbody" id="mbody">
					<br>
					<div>Center Business number</div>
					<input type='text' class='id' name='ctCode'
						placeholder='사업자번호를 입력하세요' /><br> <br>
					<div>Code</div>
					<input type='text' class='id' name='sfId' placeholder='코드를 입력하세요' /><br>
					<br>
					<div>Password</div>
					<input type='password' class='pw' name='sfPw' /><br> <br>
					<input class="login" type="button" value="직원로그인"
						onClick="ctLogIn()" />
				</div>
				<br>
				<!-- 모달 푸터 <div id = "list">${list} </div> -->
				<div class="mfooter">
					<input type="button" class="mbtn" value="비밀번호변경"
						onClick="sendEmailForm()" /> <input type="button" class="mbtn"
						value="센터가입" onClick="goJoinPage()" /> <br> <br>
					${sfInfo.sfName}
				</div>

			</div>
		</div>

	</form>
</body>
</html>
