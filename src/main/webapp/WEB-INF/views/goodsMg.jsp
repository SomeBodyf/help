<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!----======== CSS ======== -->
<link rel="stylesheet" href="res/css/goodsMg.css">
<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

<title>GoodsManament</title>
<script src="res/js/resource.js" src="res/js/bon.js"
	src="res/js/YGoods.js" src="res/js/Dong.js"></script>


</head>
<body onload="goodsMg('${sfInfo.ctCode}')">
	<nav class="sidebar close">
		<header>
			<div class="image-text">
				<span class="image"> <!--<img src="logo.png" alt="">-->
				</span>

				<div class="text logo-text">
					<span class="name">HELP</span> <span class="profession"
						onClick="goMePage('${sfInfo.ctCode}')">Health Plan </span>
				</div>
			</div>

			<i class='bx bx-chevron-right toggle'></i>
		</header>

		<div class="menu-bar">
			<div class="menu">

				<ul class="menu-links">
					<li class="nav-link"onClick="goMePage('${sfInfo.ctCode}')"><a>
					<i class='bx bx-user icon'></i> 
					<span class="text nav-text">회원관리</span>
					</a></li>

					<li class="nav-link" onClick="goSfPage('${sfInfo.ctCode}')"><a>
					<i class='bx bx-group icon'id="sfMg" ></i> 
					<span class="text nav-text">직원관리</span>
					</a></li>

					<li class="nav-link" onClick="goLessonPage('${sfInfo.ctCode}')"><a> 
					<i class='bx bx-chalkboard icon' id="lessonMg"></i>
					<span class="text nav-text">수업관리</span>
					</a></li>

					<li class="nav-link" onClick="goGoodsPage('${sfInfo.ctCode}')"><a>
					<i class='bx bx-wrench icon' id="goodsMg" ></i>
					<span class="text nav-text">장비관리</span>
					</a></li>

					<li class="nav-link" onClick="goPayPage('${sfInfo.ctCode}')"><a> 
					<i class='bx bx-credit-card icon' id="payMg"></i> 
					<span class="text nav-text">결제관리</span>
					</a></li>


				</ul>
			</div>

			<div class="bottom-content">
				<li class=""><a> <i class='bx bx-id-card icon'></i>
						<span class="text nav-text"> <span class="text nav-text">
								<span>${sfInfo.sfName}</span> <span>(${sfInfo.sfRankName})</span>
						</span>
					</span>
				</a></li>

				<li class=""><a onClick="logOut('${sfInfo.ctCode}','${sfInfo.sfId}')">
				<i class='bx bx-log-out icon' ></i> 
				<span class="text nav-text" >로그아웃</span>
				</a></li>

				<li class="mode">
					<div class="sun-moon">
						<i class='bx bx-moon icon moon'></i> <i class='bx bx-sun icon sun'></i>
					</div> <span class="mode-text text">다크모드</span>

					<div class="toggle-switch">
						<span class="switch"></span>
					</div>
				</li>

			</div>
		</div>

	</nav>

	<section class="home">
		<div class="text">GoodsManagement</div>

		<div id="infoGo">
			<div class="search">
				<div class="nav-search">
					<select class="select" id="searchCategory">
						<label for="searchGoods">장비검색</label>
						<option disabled selected>장비분류</option>
						<option>장비명</option>
						<option>담당자</option>
					</select> <span> <input type="text" placeholder="검색"> <i
						class='bx bx-search icon' onClick="searchGoods('${ctCode}')">
					</i>
					</span>
				</div>

			</div>
		</div>


		<div class="etc">
			<div>
				<button>
					<i class='bx bx-plus' onClick="getGoodsCode('${ctCode}')"></i>
				</button>
				<button>
					<i class='bx bx-edit-alt icon' onClick="getCaCode('${ctCode}')"></i>
				</button>
			</div>
		</div>


	</section>
	<table id="ajax"></table>
	<div class="gModal" id="gModal">
		<div class="goodsLog">
			<div class="gcontent">
				<div class="gheader">
					<h4 class="mtitle" id="mdtitle"></h4>
				</div>
				<div class="mbody" id="mdbody"></div>
				<div class="mbody" id="mbody">
					<input type="button" class="mbtn" onclick="closeModal()" value="닫기" />
				</div>
			</div>
		</div>
	</div>

	<script>
	 const body = document.querySelector('body'),
     sidebar = body.querySelector('nav'),
     toggle = body.querySelector(".toggle"),
     //searchBtn = body.querySelector(".search-box"),
     modeSwitch = body.querySelector(".toggle-switch"),
     modeText = body.querySelector(".mode-text");
	toggle.addEventListener("click" , () =>{
   sidebar.classList.toggle("close");
	})
	modeSwitch.addEventListener("click" , () =>{
   body.classList.toggle("dark");
   
   if(body.classList.contains("dark")){
       modeText.innerText = "라이트모드";
   }else{
       modeText.innerText = "다크모드";
       
   }
	});
	</script>

</body>
</html>