<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ctJoinForm Page</title>
</head>
<body>
	<div id="getSelectCenter">
		
		<div id="Create an Account">Create an Account</div>
			<span id="Member" onClick="getSelectCenter()">Member</span> <span id="Center" onClick="ctJoinForm()"> | Center</span>
			<form>
				<table>
					<tr>
						<td id="lo">Name</td>
					</tr>
					<tr>
						<td><input class="input" type="text"/></td>
					</tr>
					<tr>
						<td id="lo">Phone Number</td>
					</tr>
					<tr>
						<td><input class="input" type="text" pattern="(010)-\d{3,4}-\d{4}" title="형식 010-0000-0000"></td>
					</tr>
					<tr>
						<td id="lo">Member Code</td>
					</tr>
					<tr>
						<td><input class="input" type="text" placeholder="Max"/></td>
					</tr>
					<tr>
						<td id="lo">ID</td>
					</tr>
					<tr>
						<td><input class="input" type="email" placeholder="Email 입력"/></td>
					</tr>
					<tr>
						<td id="lo">Birth</td>
					</tr>
					<tr>
						<td><input class="input" type="date"/></td>
					</tr>
					<tr>
						<td id="lo">Sex</td>
					</tr>
					<tr>
						<td>
							<input type='checkbox' name='human' value='male' onclick='checkOnlyOne(this)'/> 남자
							<input type='checkbox' name='human' value='female' onclick='checkOnlyOne(this)'/> 여자
						</td>
					</tr>
					<tr>
						<td id="lo">Password</td>
					</tr>
					<tr>
						<td><input class="input" type="password" maxlength='15'/></td>
					</tr>
					<tr>
						<td id="lo">Confirm Password</td>
					</tr>
					<tr>
						<td><input class="input" type="password" maxlength='15'/></td>
					</tr>
					<tr>
						<td><input class="input" type="submit" value="Create an Account"
							onClick="meJoin()" /></td>
					</tr>
					

				</table>
			</form>
	</div>
</body>
</html>