<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!----======== CSS ======== -->
<link rel="stylesheet" href="res/css/payMg.css">
<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
<title>PayManagement</title>
<script src="res/js/resource.js" src="res/js/YPay.js"  src="res/js/bon.js" src="res/js/Dong.js"> </script>


</head>
<body onLoad="onLoadPay('${sfInfo.ctCode}')">
	<nav class="sidebar close">
		<header>
			<div class="image-text">
				<span class="image"> <!--<img src="logo.png" alt="">-->
				</span>

				<div class="text logo-text">
					<span class="name">HELP</span> <span class="profession"  onClick="goMePage('${sfInfo.ctCode}')">Health
						Plan </span>
				</div>
			</div>

			<i class='bx bx-chevron-right toggle'></i>
		</header>

		<div class="menu-bar">
			<div class="menu">

				<ul class="menu-links">
					<li class="nav-link"><a> <i class='bx bx-user icon'
							onClick="goMePage('${sfInfo.ctCode}')"></i> <span
							class="text nav-text">회원관리</span>
					</a></li>

					<li class="nav-link"><a> <i class='bx bx-group icon'
							id="sfMg" onClick="goSfPage('${sfInfo.ctCode}')"></i> <span
							class="text nav-text">직원관리</span>
					</a></li>

					<li class="nav-link"><a> <i class='bx bx-chalkboard icon'
							id="lessonMg" onClick="goLessonPage('${sfInfo.ctCode}')"></i> <span
							class="text nav-text">수업관리</span>
					</a></li>

					<li class="nav-link"><a> <i class='bx bx-wrench icon'
							id="goodsMg" onClick="goGoodsPage('${sfInfo.ctCode}')"></i><span
							class="text nav-text">장비관리</span>
					</a></li>

					<li class="nav-link"><a> <i class='bx bx-credit-card icon'></i>
							<span class="text nav-text" id="payMg"
							onClick="goPayPage('${sfInfo.ctCode}')">결제관리</span>
					</a></li>


				</ul>
			</div>

			<div class="bottom-content">
				<li class=""><a href="#"> <i class='bx bx-id-card icon'></i>
						<span class="text nav-text"><span class="text nav-text">
								<span>${sfInfo.sfName}</span> <span>(${sfInfo.sfRankName})</span>
						</span></span>
				</a></li>

				<li class=""><a> <i class='bx bx-log-out icon'
						onClick="logOut('${sfInfo.ctCode}','${sfInfo.sfId}')"></i> <span class="text nav-text" onClick="logOut('${sfInfo.ctCode}','${sfInfo.sfId}')">로그아웃</span>
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
		<div class="text">PayManagement</div>

		<div id="infoPa">
			<div class="search">
				<div class="nav-search">
					<div class="middle"></div>

					<div class="side">
						<script
							src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
						<canvas id="bar-chart" width="300" height="230"></canvas>
					</div>
					<form>
						<input id="searchDate" type="date" /> <input type="button"
							class='bx bx-search icon' value="찾기"
							onClick="searchPay('${sfInfo.ctCode}')" />
					</form>
				</div>
			</div>
		</div>

		<table id="ajax"></table>
	</section>







	<script>
const d = new Date();
const year = d.getFullYear(); // 년
const month = d.getMonth();   // 월

new Chart(document.getElementById("bar-chart"), {
    type: 'bar',
    data: {
      labels: [new Date(year, month - 3).toLocaleDateString().substring(2,8),
	  new Date(year, month - 2).toLocaleDateString().substring(2,8),
      new Date(year, month - 1).toLocaleDateString().substring(2,8)],
      datasets: [
        {
        
          label: "만원",
          backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f"],
          data: [${paGraph[0].paTotal},${paGraph[1].paTotal},${paGraph[2].paTotal}]
        }
      ]
    },
    options: {
    responsive: false,
			scales: {
				yAxes: [{
					ticks: {
						min: 0,
						max: 300,
						fontSize : 12,
					}
				}]
			},
      
      legend: { display: false },
      title: {
        display: true,
        text: '최근 3개월 매출(단위 만)'
        
      }
      
    }
});


</script>

</body>
</html>