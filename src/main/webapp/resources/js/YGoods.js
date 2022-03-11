function ajaxconnection(action, data, fn, content) {
   let ajax = new XMLHttpRequest();
   ajax.onreadystatechange = function() {
      if (ajax.readyState == 4 && ajax.status == 200) {
         window[fn](JSON.parse(ajax.responseText));
      }
   };
      ajax.open("post", action, true);
if(content){
      ajax.setRequestHeader("Content-type", "application/json; charset=utf-8");
   }
   ajax.send(data);
}

function goodsMg(ctCode){
	json=[];
	json.push({ctCode:ctCode});
	const data = JSON.stringify(json);
	ajaxconnection("ajax/goodsMg", data, "goodsList", true);
}
let goodsInfo;
function goodsList(json){
	let body = document.getElementById("ajax");
	let data;
	if(json.length>0){
		goodsInfo = json;
		data = "<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>장비코드</span><span>&nbsp;&nbsp;&nbsp;&nbsp;장비명</span><span>&nbsp;&nbsp;&nbsp;&nbsp;분류</span><span>&nbsp;&nbsp;&nbsp;&nbsp;담당자</span><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관리일자</span><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상태</span></div>";
		for(i=0;i<json.length;i++){
			data += "<div>";
			data += "<span>&nbsp;&nbsp;<input type=\"radio\" name=\"radibut\" value=\""+i+"\"></span>";
			data += "<span>&nbsp;&nbsp;&nbsp;"+json[i].eqCode+"</span>";
			data += "<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+json[i].eqName+"</span>";
			data += "<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+json[i].eqCaName+"</span>";
			data += "<span>&nbsp;&nbsp;&nbsp;&nbsp;"+json[i].sfName+"</span>";
			data += "<span>&nbsp;&nbsp;&nbsp;&nbsp;"+json[i].egDate+"</span>";
			data += "<span>&nbsp;&nbsp;&nbsp;&nbsp;"+json[i].stName+"</span>";
		}
	body.innerHTML = data;
	}else{const msg = document.getElementsByClassName("searchGo")[0];
			msg.value = "";
			msg.placeholder="검색어를 확인해 주세요.";}
}

function searchGoods(ctcode){
	const searchText = document.getElementById("searchCategory");
	const searchGo = document.getElementsByClassName("searchGo")[0].value;
	let json = [];
	json.push({ctCode:ctcode,eqCaCode:searchText.value,eqCaName:searchGo});
	if(searchGo==""){
		goodsMg(ctcode);
	}else{
		const data = JSON.stringify(json); 
		ajaxconnection("ajax/searchGoods", data, "goodsList", true);
	}
}

function modGoods(ctcode){
	var radio =document.getElementsByName("radibut");
	let idx;
	for (i=0; i<radio.length; i++) {
		if (radio[i].checked == true) {
			idx = i;
		}
	}
	subModGoods();
	document.getElementById("mdtitle").innerText = "장 비 수 정";
	let data = "<div><span>장비코드</span><br><span id=\"ctCode\">"+goodsInfo[idx].eqCode+"</span></div>";
	data += "<div><span>장비명</span><br><input type=\"text\" placeholder=\""+goodsInfo[idx].eqName+"\"/></div>";
	data += "<div><span>분류</span><br><span>"+goodsInfo[idx].eqCaName+"</span></div>";
	data += "<div><span>담당자</span><br><span>"+goodsInfo[idx].sfName+"</span></div>";
	data += "<div><span>관리일자<span><br><span>도와줘 유일애몽!!!!!</span></div>";
	data += "<div><span>상태</span><br>";
	data += "<select id=\"caCodeList\">";
	
	data += "</select>"
	document.getElementById("mdbody").innerHTML=data;
		openModal();
}

function subModGoods(){
	
}

function insGoods(ctcode){
	openModal();
}

function openModal(){
	let container = document.getElementById("gModal");
	container.style.filter = "alpha(Opacity=50)";
	container.style.display = "block";
}

function closeModal(){
	let container = document.getElementById("gModal");
	container.style.display = "none";
}

















