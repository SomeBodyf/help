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
						<td id="lo">CEO Name</td>
					</tr>
					<tr>
						<td><input class="input" type="text"/></td>
					</tr>
					<tr>
						<td id="lo">CEO Email</td>
					</tr>
					<tr>
						<td><input class="input" type="email" placeholder="Email 입력"/></td>
					</tr>
					<tr>
						<td id="lo">CEO Phone Number</td>
					</tr>
					<tr>
						<td><input class="input" type="text" pattern="(010)\d{3,4}\d{4}" title="형식 01000000000"></td>
					</tr>
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
						<td><input class="input" type="password" maxlength='15'/></td>
					</tr>
					<tr>
						<td id="lo">Confirm Password</td>
					</tr>
					<tr>
						<td><input class="input" type="password" maxlength='15'/></td>
					</tr>
					<tr>
						<td id="lo">Center</td>
					</tr>
					<tr>
						<td><input class="input" type="text" pattern="d{3}/d{2}/d{5}" title="형식 0000000000" placeholder="사업자등록번호"/></td>
					</tr>
					<tr>
						<td id="lo">Center Name</td>
					</tr>
					<tr>
						<td><input class="input" type="text"/></td>
					</tr>
					<tr>
  						<td>우편번호</td>
  						<td>
   						 <input type="text" name="zipcode" size="7" id="sample6_postcode" placeholder="우편번호">
   						 <input type="button" class="btn btn-primary btn-sm" value="우편번호찾기" onclick="sample6_execDaumPostcode()">
 					    </td>
					</tr>
					<tr>
 					 	<td>주소</td>
 					 <td>
   						 <input type="text" name="address1" size="40" id="sample6_address" placeholder="주소">
							 <br>
						 <input type="text" name="address2" size="40" id="sample6_address2" placeholder="상세주소">
 					 </td>
					</tr>
					<tr>
						<td><input class="input" type="submit" value="Create an Account"
							onClick="ctJoin()" /></td>
					</tr>
					

				</table>
			</form>
	</div>
</body>
</html>