<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax - @PutMapping => DTO로 처리</title>
<script src="./jquery.js"></script>
<script>
$(function () {
    // DOM이 준비된 이후 실행
    $("#jqbtn").click(function () {
      console.log("test");
    });
  });
</script>
</head>
<body>
	입력값 : <input type="text" id="pd1"><br>
	입력값 : <input type="text" id="pd2"><br>
	입력값 : <input type="text" id="pd3"><br>
	입력값 : <input type="text" id="pd4"><br>
	입력값 : <input type="text" id="pd5"><br>
	<input type="button" value="AJAX 전송" onclick="ajax_put()"><br>
	<input type="button" value="jquery 전송" id="jqbtn"><br>
	<input type="button" value="ES AJAX 전송" id="btn">
</body>
<script>
function ajax_put() {
	   //eval() => 문자 형태를 Script화 시켜주는 역할 함수
	   var a = 1;
	   while(a < 6){
	      eval("var pd" + a + "= document.getElementById('pd'+a).value");
	      a++;
	   }
	   
	   // 키배열 pd1 ~ pd5
	   var keyarray = {
			   pd1: pd1,
			   pd2: pd2,
			   pd3: pd3,
			   pd4: pd4,
			   pd5: pd5
	   };
	   var json = JSON.stringify(keyarray);
	   console.log(json);
	   var data = new URLSearchParams(keyarray).toString();
	   
	   var http,result;
	   http = new XMLHttpRequest();
	   http.open("PUT","./ajax14/a123456",false);
	   http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	   http.onload = function() {
	      result = this.response;
	      if(result == "ok"){
	    	   alert("저장 완료");
	    	   location.href.reload();
	       }else{
	    	   alert("저장 실패");
	       }
	   }
	   http.onerror = function() {
	      console.log("통신오류!!");
	   }
	   http.send(json);

	}
</script>
<script type="module">
import {api_insert} from "./ajax13.js";
document.querySelector("#btn").addEventListener("click",function(){
	new api_insert().api_put();
});
</script>
</html>




