<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax(PATCH) - REST API Server</title>
<script src="./jquery.js"></script>
<script>
	$(function() {
		$("btn").click(function() {
			var $mid = $("mid").val();
			// 코드 변경 배열
			$.ajax({
				url : "./ajax12.do/patch_myinfo",
				cache : false,
				type : "PATCH",
				dataType: "html",
				contentType : "application/json",
				data : JSON.stringify({
					mid : $mid,
					mname : "홍길동",
					mage : "25",
					memail : "hong@nate.com"
				}),
				success:function($data){
					console.log($data);
				},
				error:function(){
					console.log("통신오류 발생");
				}
			});
		});
	});
</script>
<!-- 
API
PATCH : update (수정)
PUT : insert (입력)
DELETE : delete (삭제)

GET(보안X), POST(보안) : select (검색)
 -->
</head>
<body>
	아이디 : <input type="text" id="mid"><br>
	<input type="button" value="JS 클릭" onclick="ajaxs()"><br>
	<input type="button" value="JQ 클릭" id="btn">
</body>
<script>
function ajaxs() {
   
   var mid = document.getElementById("mid");
   var arr = new Array();
   arr[0] = mid.value;
   arr[1] = "apink@naver.com";
   arr[2] = "01010041004";
   arr[3] = "서울시 종로구";
   
   var http,result;
   http = new XMLHttpRequest();
   // http.open("PATCH","./ajax12.do/"+mid.value,false); // 한 개의 데이터값
   // 배열값 및 보안 코드를 적용하여 API로 연결하는 방식
   http.open("PATCH","./ajax12.do/patch_myinfo",false); // 보안코드 (patch_myinfo라는 단어로)
   //http.setRequestHeader("content-type","application/x-www-form-urlencoded");
   http.setRequestHeader("content-type","application/json");
   http.onload = function() {
      console.log(this.response);
   };
   http.onerror = function(){
      console.log("통신오류 발생!");
   };
   http.send(JSON.stringify(arr)); // JSON.stringify(배열) => send 함수를 이용하여 전달 

}
</script>
</html>






