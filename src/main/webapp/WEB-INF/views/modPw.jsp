<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modPw Page</title>
</head>
<body>
	<div id="modPw">
		
		<div id="modPassword">Modify Password</div>
			<form>
				<table>
					<tr>
						<td id="lo">ID</td>
					</tr>
					<tr>
						<td><input class="input" type="text"/></td>
					</tr>
					<tr>
						<td id="lo">Password</td>
					</tr>
					<tr>
						<td><input class="input" type="password"/></td>
					</tr>
					<tr>
						<td><input class="input" type="button" value="Mod Password"
							onClick="modPw()" /></td>
					</tr>
					<tr class="line">
						<td>
							<input type="button" value="회원가입" onClick="goMeJoinPage()"/>
							<input type="button" value="센터가입" onClick="ctJoin()"/>	
						</td>
					</tr>

				</table>
			</form>
	</div>
</body>
</html>