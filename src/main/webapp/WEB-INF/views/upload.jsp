<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Multi-Part Upload</title>
<script src="res/js/resource.js"></script>
<script>
	function uploadFile(formName) {
	
		 const form = document.getElementsByName(formName)[0];
		form.submit();
	}
	function UploadFilebyAJax(formName) {
		 const form = document.getElementsByName(formName)[0];

		 //폼서브밋vs 에이작스 send
				 let data = new FormData(form);
				 ajaxFromData("/MultiPart2",data,"ajaxCallback","POST");
	}
	
	function ajaxFromData(action, data, fn, method) {
		const ajax = new XMLHttpRequest();
		
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4 && ajax.status == 200) {
			//alert(ajax.responseText);
			window[fn](JSON.parse(ajax.responseText));
			
			
		}
		};
		if(method == "Get"){
			ajax.open("get", action, true);
		}
		else{
		ajax.open("post", action, true);
		//ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8 ");
		}
		ajax.send(data);
	}
	
	function ajaxCallback(){
		alert("파일 전송완료");
	}
	
</script>
<link rel="stylesheet" type="text/css" href="res/css/common.css" />
<style>
body	{font-family: 'Black Han Sans', sans-serif;}
table {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 52%;
}

td {
	text-align: center;
}

input {
	width: 98%;
	height: 40px;
	text-align: center;
	font-size: 15pt;
	color: #0BC904;
	font-family: 'Black Han Sans', sans-serif;
}

#state {
	text-align: left;
	padding-left: 20px;
}

#ips {
	text-align: right;
	padding-right: 20px;
}

#btn {
	background-color: #0BC904;
	color: #FFFFFF;
	width: 99%;
	height: 60px;
	border: 1px solid #0BC904;
	cursor: pointer;
}

.title {
	height: 80px;
	font-size: 20pt;
	background-color: #0BC904;
	color: #FFFFFF;
}

.line {
	height: 60px;
}
</style>
</head>

<body onLoad="loadPage('${msg}')">
<!--  
	<form name="nname" action="MultiPart" method="post" enctype="multipart/form-data">
		<table>
			<tr class="title">
				<td>File Upload</td>
			</tr>
			<tr class="line">
				<td><input type="file" name="file" multiple/></td>
			</tr>
			<tr>
				<td><input type="text" name="title"  placeholder="파일명"/></td>
			</tr>
			<tr >
				<td><input type="text" name="content" placeholder="내용"/></td>
			</tr>
			<tr>
				<td>					
					<input type="button" id="btn" value="파일전송"
					onClick="uploadFile('nname')" /></td>
			</tr>
		</table>
	</form>
	-->
	<form name="excel" action="MultiPart2" method="post" enctype="multipart/form-data">
		<table>
			<tr class="title">
				<td>AJAX File Upload</td>
			</tr>
			<tr class="line">
				<td><input type="file" name="file" multiple/></td>
			</tr>
			<tr>
				<td><input type="text" name="title"  placeholder="파일명"/></td>
			</tr>
			<tr >
				<td><input type="text" name="content" placeholder="내용"/></td>
			</tr>
			<tr>
				<td>					
					<input type="button" id="btn" value="파일전송"
					onClick="UploadFilebyAJax('nname2')" /></td>
			</tr>
		</table>
	</form>
</body>
</html>