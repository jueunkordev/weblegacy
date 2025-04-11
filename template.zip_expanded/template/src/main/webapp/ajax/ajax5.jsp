<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax - jquery로 전송(POST) - JSON.stringify</title>
<script src="./jquery.js"></script>
<script>
$(function(){
	// json.stringify 전송 : 대표키 포함하여 보내기 vs 대표키 없이 보내기
	// 대표키 X
	var $data = new Array();
	$data[0] = "홍길동";
	$data[1] = "이순신";
	$data[2] = "장보고";
	$("#btn").click(function(){
		$.ajax({
			url: "./ajax6.do",
			cache: false,
			type: "POST",
			dataType: "html",
			contentType: "application/json",
			//data: JSON.stringify($data), // 대표키 없이 전송
			data : JSON.stringify({userdata : $data}), //대표키가 있는 상태에서 보내기
			async: true,
			success: function($result){
				console.log($result); // 서버 응답
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