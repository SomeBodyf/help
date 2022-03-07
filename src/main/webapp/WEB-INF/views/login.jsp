<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store Login</title>
<script src="res/js/resource.js"></script>
<link rel="stylesheet" type="text/css" href="res/css/common1.css" />


</head>
<body onLoad = "loadPage('${msg}')">
<input type="hidden" id="video" value=""/> <!-- 파일명 확인용 -->


<div id = list>show api using bootStrap</div>


	<form action="authenticationMa" name = "login" method="post">
		<table>
			<tr>
				<td id="lo">STORE LOGIN</td>
			</tr>
			<tr>
				<td><input class = "inputt" type="text" name="stCode" placeholder="STORE ID" /></td>
			</tr>
			<tr>
				<td><input class = "inputt" type="text" name="elCode" placeholder="EMPLOYEE ID" /></td>
			</tr>
			<tr>
				<td><input class = "inputt" type="passWord" name="elPassword"
					placeholder="PASSWORD" /></td>
			</tr>
			
			
			
			<tr>
				<td><input class="lo2" type="button" value="LOGIN"
					onClick="jstest()" /></td>
			</tr>
			<tr class="line">
				<td><a  href="PasswordForm" >비밀번호 찾기는 여기서</a>
				<a  href="getFilePage" >파일업로드</a></td>
			</tr>

		</table>
	</form>
</body>

</html>
