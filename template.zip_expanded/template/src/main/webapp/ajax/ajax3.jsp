<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax (POST)- FormData</title>
</head>
<body>

	<input type="button" value="전송" onclick="ajax_gopage()"><br>
	<input type="button" value="전송 form 키가 다를 경우" onclick="ajax_gopage2()">
</body>
	<!-- 
	POST 값 전송
	1. Array를 이용하여 데이터 전송
	2. FormData를 이용하여 데이터 전송
	3. JSON.Stringify를 이용하여 데이터 전송
	 -->
<script src="./ajax3.js?v=7"></script>
</html>