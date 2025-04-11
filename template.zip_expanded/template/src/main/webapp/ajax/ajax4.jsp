<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax - jquery로 전송(GET) - JSON.stringify를 이용한 전송</title>
<script src="./jquery.js"></script>
<script>
$(function(){
	$("#btn").click(function(){
		var $ajaxdata = [];
		$ajaxdata[0] = "홍길동";
		$ajaxdata[1] = "이순신";
		$ajaxdata[2] = "장보고";

		// JSON 문자열로 변환
		var $fdata = JSON.stringify($ajaxdata);
		// JSON.stringify => {[]} 배열화
		// Ajax 요청
		$.ajax({
			url: "./ajax5.do?no=" + encodeURIComponent($fdata),
			cache: false,
			type: "GET",
			dataType: "html",
			async: true,
			success: function(result){
				console.log(result); // 서버 응답
			},
			error: function(){
				console.log("백엔드와 통신 오류 발생");
			}
		});
	});
});
</script>
</head>
<body>

	<input type="button" value="전송" id="btn"><br>
</body>
</html>