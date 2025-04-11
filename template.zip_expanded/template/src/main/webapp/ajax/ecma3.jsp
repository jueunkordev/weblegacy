<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECMA - ES7 ~ 기초 코드2 (Class 및 외부 js 로드)</title>
</head>

<body>
	<form>
		검색 : <input type="text" id="mid"><br>
		<button type="button" id="btn">검색</button>
	</form>
</body>
<script type="module">
import {zzz} from "./ecma2.js"; // zzz 함수를 로드
import {logins} from "./ecma3.js"; // logins라는 class를 로드

new logins.search_ck();
</script>

</html>