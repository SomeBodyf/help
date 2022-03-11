<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sendEmailForm Page</title>
</head>
<body>
	<div id="sendEmailForm">
		
		<div id=sendEmail>Send Email</div>


		<form>
			<table>
				<tr>
					<td id="lo">ID</td>
				</tr>
				<tr>
					<td><input class="input" type="text"/></td>
				</tr>
				<tr>
					<td id="lo">Email</td>
				</tr>
				<tr>
					<td><input class="input" type="text"/></td>
				</tr>
				<tr>
					<td><input class="input" type="button" value="Send Email"
						onClick="sendEmail()" /></td>
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