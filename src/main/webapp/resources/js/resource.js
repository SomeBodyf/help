/**
 * 태그를 만들수 있음
 */

let jsPIp;
let list;
message = "요즘 난 Alright";
message = "너 없이는 Alright";


function getfoodApi() {
	
	
	url = "http://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?";
	url += "serviceKey=ksbKIXkJYJXghDThBDBGwyheTGM1%2Fe6GWQWen0oNQMkmDBEAYvcZKgRAmOtzIYtBHbkC1ei41ECMgoCx2ePt0A%3D%3D&desc_kor=%EB%B0%94%EB%82%98%EB%82%98%EC%B9%A9";
	url += "&pageNo=1&numOfRows=3&bgn_year=2017&animal_plant=(%EC%9C%A0)%EB%8F%8C%EC%BD%94%EB%A6%AC%EC%95%84&type=xml";
	 
	whatsend(url+ "성공","getedData",true,"get");
	}
	
	function getedData(data){
		alert(data);
	}
	

function jstest(){
	
 const sttcode= "ctCode="+2022;
	whatsend("meLogin", sttcode,"regedemp",true,"post");
	}
	
	
function getgoodsList(action, stcode){
	//let jsondata = [];
	//jsondata.push({"stCode":stcode});
	//const clientdata = JSON.stringify(jsondata);
	whatsend(action,"","writegoodslist",false,"post");

}
let data2;
function writegoodslist(data){
	data2 = data;
	const list =  document.getElementById("list");
	//let message = '<div><span>상품코드</span><span>상품이름</span><span>상품원가</span><span>상품가격</span><span>상품재고</span><span>상품할인률</span><span>판매상태</span><span>사진</span></div>';
      while(list.hasChildNodes()){
			list.removeChild(list.lastChild);
		}
	for (idx = 0; idx < data2.length; idx++) {
		
		let div = document.createElement("div");
	div.setAttribute("onClick", "showGoodsinModal("+idx+")");
	
	let span1=  document.createElement("span");
	span1.innerText = data[idx].goCode;
	let span2=  document.createElement("span");
	span2.innerText = data[idx].goName;
	let span3=  document.createElement("span");
	span3.innerText = data[idx].goPrice;
	let span4=  document.createElement("span");
	span4.innerText = data[idx].goDiscount;
	let span5=  document.createElement("span");
	span5.innerText = data[idx].goImage;
	div.appendChild(span1);
	div.appendChild(span2);
	div.appendChild(span3);   
	div.appendChild(span4);   
	div.appendChild(span5);           
//속성을 포함해서 넣으면 어펜드, 태그부터 넣을거면 innerhtml, 태그안에 텍스트만 넣을거면 innerText
  list.appendChild(div);
     }
}

//모달에서 상세정보보
function showGoodsinModal(idx){
	
	let mheader = document.getElementById("mheader");
	let mbody = document.getElementById("mbody");
	//커멘드네임 세팅
	let modalmod2 =  document.getElementsByName("modalmod")[0];
	

	modalmod2.setAttribute("onClick", "modGoodsInModal("+idx+")");
	modalmod2.setAttribute("value","상품정보수정요청");
	
	
	
	//헤더 수정
	
	mheader.innerText = data2[idx].goName +"  상세정보"+"<br>";
	//바디정보
	let body2 = "<table>"+"<td><img src=\"res/"+data2[idx].goImage+"\"/></td><td>상품코드"+data2[idx].goCode+"</td><td>상품명"+data2[idx].goName+"</td>"+
		
	"<td>매입가"+data2[idx].goCost+"</td>"+"<td>판매가"+data2[idx].goPrice+"</td>"+
	"<td>재고"+data2[idx].goStock+"</td>"+"<td>할인률"+data2[idx].goDiscount+"</td>"+"<td>판매상태"+data2[idx].goStatus+"</td></tr>";
		mbody.innerHTML = body2;
	openModal();
}


function modGoodsInModal(idx){
	//폼 수정
	let form = document.getElementsByName("dynamicFormdata")[0];
	form.setAttribute("action", "final/modGoodsInModal");
	form.setAttribute("method", "post");
	form.setAttribute("enctype", "multipart/form-data");
	
	//파일정보가져오기
	let files = document.getElementsByName("file")[0].files;

	let formdata = new FormData(form);
	formdata.append("goCode",data2[idx].goCode);
	formdata.append("goName",data2[idx].goName);
	formdata.append("goCost",data2[idx].goCost);
	formdata.append("goPrice",data2[idx].goPrice);
	formdata.append("goStatus",data2[idx].goStatus);
	formdata.append("goDiscount",data2[idx].goDiscount);
	formdata.append("goImage",files.length>0?data2[idx].goCode +"."+ files[0].type.substring(files[0].type.indexOf("/")+1) :data2[idx].goImage);
		
		formdata.append("goStock",data2[idx].goStock);
	
		
		ajaxconnection(form.getAttribute("action"),formdata,"udtedGoodsInfo",false);
		}

function udtedGoodsInfo(data){

	closeModal();
	writegoodslist(data);
	
}


function openModal() {
	let container =  document.getElementById("container");
	container.style.filter = "alpha(Opacity=50)";
	container.style.display = "block";
}
function closeModal(obj) {
	let uplodedfile =  document.getElementById("uploadfile");
	uplodedfile.innerHTML = "<input type='file' calss='mbtn' name = 'file' value='사진등록'/>";
	let container =  document.getElementById("container");
	container.style.display = "none";
}

function ajaxconnection(action, data, fn, content) {
   let ajax = new XMLHttpRequest();
   ajax.onreadystatechange = function() {
      if (ajax.readyState == 4 && ajax.status == 200) {
         window[fn](JSON.parse(ajax.responseText));
      }
   };
      ajax.open("post", action, true);
if(content){
      ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
   }
   ajax.send(data);
}

function whatsend(action, data, fn, content,method) {
	const ajax = new XMLHttpRequest();
	
	ajax.onreadystatechange = function() {
		
			if (ajax.readyState == 4 && ajax.status == 200) {
			alert(ajax.responseText);
			window[fn](JSON.parse(ajax.responseText));
		}
	};
	
	if(method == "Get"){
		
		ajax.open("get", action, true);
	}else{
		ajax.open("post", action, true);
		ajax.setRequestHeader("Content-Type",content? "application/x-www-form-urlencoded;charset=utf-8 ":"application/json;charset=utf-8");
	}
	
	ajax.send(data);
}
function getAjaxJsonUsingJquery(action, clientData, fn) {
		$.ajax({
			async : true,
			type : "post",
			url : action,
			data : clientData,
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			dataType : "json",
			success : function(jsonObject){
				alert("AJAX 통신 성공으로 서버 데이터가 도착했습니다.");
				alert(JSON.stringify(jsonObject));
				window[fn](jsonObject);
			},
			beforeSend : function(){
				// AJAX 통신 요청 전 호출되는 이벤트
				alert("AJAX 통신을 시작합니다.");
			},
			complete : function(){
				// AJAX 통신이 완료 될 때 호출되는 이벤트
				alert("AJAX 통신을 종료합니다.");
			},
			err : function(error){
				// 통신 실패시 호출되는 이벤트
				alert("AJAX 통신실패했습니다.");
			},
			timeout : 10000
		});
	}
	
function getmemList(list, stcode, elcode){

	let data = "stCode=" + encodeURIComponent(stcode);
	
	//getAjaxJson(list, data, "getedmemlist", "post")
	
	
	getAjaxJsonUsingJquery("ajax/MemberList", data, "getedmemlist");
	
}

function getedmemlist(data){
	 message = '<table><tr><td>매장코드</td><td>회원코드</td><td>회원이름</td><td>회원등급</td></tr>';
      for (idx = 0; idx < data.length; idx++) {
         message += '<tr><td>' + data[idx].stCode + '</td><td>'
               + data[idx].cmCode + '</td><td>' + data[idx].cmName
               + '</td><td>' + data[idx].cmRank + '</td>';
         message += '</tr>';
      }
      message += '</table>';
      document.getElementById("list").innerHTML = message;
	
}
function getempList(list, stcode, elcode){
	

	let data = "stCode=" + encodeURIComponent(stcode)+"&elCode="+encodeURIComponent(elcode);
	
	whatsend(list, data, "getedemplist", "post")
}
function getedemplist(data){
	
	message = '<table><tr><td>매장코드</td><td>직원코드</td><td>직원이름</td><td>직원등급</td></tr>';
      for (idx = 0; idx < data.length; idx++) {
         message += '<tr><td>' + data[idx].stCode + '</td><td>'
               + data[idx].elCode + '</td><td>' + data[idx].elName
               + '</td><td>' + data[idx].lvCode+ '</td>';
         message += '</tr>';
      }

      message += '</table>';


      document.getElementById("list").innerHTML = message;
	
}
function isEmpty(obj) {
		let check = true;
		if (obj.value == "") {
			check = false;
		}
		return check;

	}



function makeForm(fname, faction, fmethod){
	const form = document.createElement("form");
	if(fname != ""){form.setAttribute("name", fname);}
	form.setAttribute("action", faction);
	form.setAttribute("method", fmethod);
	return form;
}

function makeInputElement(type, name, value, placeholder){
	const input = document.createElement("input");
	input.setAttribute("type", type);
	input.setAttribute("name", name);
	if(value != ""){input.setAttribute("value", value);}
	if(placeholder != ""){input.setAttribute("placeholder", placeholder);}
	
	return input;
}

function getmanagepage(stcode,elcode,lvcode){
	
	const form = makeForm("", "GETMANAGEMENTPAGE", "get")
const StCode = makeInputElement("hidden","StCode",stcode,"");
const ElCode = makeInputElement("hidden","ElCode",elcode,"");    
const lvCode = makeInputElement("hidden","lvCode",lvcode,"");

form.appendChild(lvCode);
form.appendChild(StCode);
form.appendChild(ElCode);
      
      document.body.appendChild(form);
      form.submit();
	
	
}
function getsalespage(stcode,elcode,lvcode){
	
	const form = makeForm("", "GETSALESPAGE", "get")
const StCode = makeInputElement("hidden","StCode",stcode,"");
const ElCode = makeInputElement("hidden","ElCode",elcode,"");    



form.appendChild(StCode);
form.appendChild(ElCode);
      
      document.body.appendChild(form);
      form.submit();
	

}




function initPage(){
	 whatsend("https://api.ipify.org?format=json","","getPublicIp","Get");
}

function loadPage(msg){
	if(!msg=="")
	alert(msg);
}

function getPublicIp(pip){
	jsPIp = pip.ip;
}


function logout(stcode,elcode){
	
   const form = makeForm("", "AccessOut", "post")
    const StCode = makeInputElement("hidden","StCode",stcode,"");
const ElCode = makeInputElement("hidden","ElCode",elcode,"");
const PublicIp = makeInputElement("hidden","PublicIp",jsPIp,"");
	form.appendChild(StCode);
	form.appendChild(ElCode);
	form.appendChild(PublicIp);
      
      document.body.appendChild(form);
      form.submit();
   
}






function makeForm(fname, faction, fmethod){
	const form = document.createElement("form");
	if(fname != ""){form.setAttribute("name", fname);}
	form.setAttribute("action", faction);
	form.setAttribute("method", fmethod);
	return form;
}

function makeInputElement(type, name, value, placeholder){
	const input = document.createElement("input");
	input.setAttribute("type", type);
	input.setAttribute("name", name);
	if(value != ""){input.setAttribute("value", value);}
	if(placeholder != ""){input.setAttribute("placeholder", placeholder);}
	
	return input;
}


function isEmpty(obj) {
		let check = true;
		if (obj.value == "") {
			check = false;
		}
		return check;

	}
	
	 
function auth() {

	
	const hidden = makeInputElement("hidden","publicIp",jsPIp,"");
	let form = document.getElementsByName("login")[0];
	form.appendChild(hidden);
	
	const userData = [document.getElementsByName("stCode")[0],
	document.getElementsByName("elCode")[0],
	document.getElementsByName("elPassword")[0],
	document.getElementsByName("publicIp")[0]];


	
 	message = ["매장코드없음","직원코드없음","직원비번없음","ip안넘어옴"];
for(let index = 0; index< userData.length; index++){
	if(!isEmpty(userData[index])){
		alert(message[index]);

		return;
	}
}
	
        form.submit();
	
      }


function ClickOrderList(srCode){
		let list = document.getElementById("list");
		
		while(list.hasChildNodes()){
			list.removeChild(list.lastChild);
		}
					
	const day = document.querySelector("#date").value;
	if(day==""){
		alert("날짜를 선택해주세요.");
		return;
	}
		let data = "srCode=" + encodeURIComponent(srCode)+"&otDate="+encodeURIComponent(day);
	//alert(data);
	whatsend("GetOrderInfo",data, "addOrders");
	
		}
		
let orderOne = [];		



	
	


	

function addOrders (ordersInfo) {

	let list = document.getElementById("list");	
	if(Object.keys(ordersInfo).length != 0){
	for (colIndex= 0; colIndex <Object.keys(ordersInfo).length ; colIndex++) {	
		
		orderOne[colIndex] = 
   		"<span id = 'otDate'>"+ordersInfo[colIndex].otDate+"</span>"+'\u00A0'+
        "<span id = 'otTime'>"+ ordersInfo[colIndex].otTime+"에"+"</span>"+'\u00A0'+
      	"<span id = 'meCode'>"+ordersInfo[colIndex].meCode+"</span>"+
        "<span id = 'meName'>"+ordersInfo[colIndex].meName +"</span>"+'\u00A0'+"*"+'\u00A0'+
        "<span id = 'otQuantity'>"+ordersInfo[colIndex].otQuantity+"개"+"</span>"+'\u00A0'+
        "<span id = 'cuName'>"+ordersInfo[colIndex].cuName+"</span>"+"("+'\u00A0'+
        "<span id = 'cuNumber'>"+ordersInfo[colIndex].cuNumber+"</span>"+") 님이"+
        "<span id = 'stCode'>" +ordersInfo[colIndex].stCode+"</span>"+'\u00A0'+
        "<span id = 'stName'>"+ordersInfo[colIndex].stName+"</span>"+"하셨습니다.";
					
		let div = document.createElement("div");
		div.setAttribute("class","oneorder");
		div.innerHTML = orderOne[colIndex];
				
			
		list.appendChild(div);
	}
		}else{
			alert("해당 날짜의 주문이 없습니다.");
		}
			
}

document.onkeydown = function(e){
	// 새로고침 Ctrl+R Ctrl+N
	const k = e.keyCode;
	//F5
	if(k == 116 || (e.ctrlKey && k == 82)){
		refresh('1006','1006');
		e.preventDefault(); //기존이벤트사용하게방지
		e.returnValue = ''; //크롬필수로 ㄷ리턴값줘야함
	}
	
}

function refresh(stCode, elCode) {
	
	const form = makeForm("", "Refresh", "post");
	const clientData = [makeInputElement("hidden", "stCode", stCode, ""), makeInputElement("hidden", "elCode", elCode, ""), makeInputElement("hidden", "publicIp", publicIp, "")];
	
	for(idx=0; idx<clientData.length;idx++){
		form.appendChild(clientData[idx]);
	}		

	document.body.appendChild(form);
	form.submit();
}





	

		
		




