// ajax => GET 통신
function ajax_gopage(){
	var ajax, result;

	var data = new FormData();
	data.append("pd","홍길동");	// append("키명","데이터")
	data.append("pd","이순신");
	data.append("pd","유관순");

	ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		if(ajax.readyState == 4){
			if(ajax.status == 200){
				console.log(this.response);
			}
		}
	}

	ajax.open("POST","./ajax3.do",true);
	ajax.setRequestHeader("content-type","application/json");
	ajax.send(data);	// formData 함수로 생성된 객체를 전송
}

function ajax_gopage2(){
	var ajax, result;
	
	var data = [];
	data.push(
				{"pd1":"홍길동"},
				{"pd2":"강감찬"},
				{"pd3":"유관순"}
			  );
	
	ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		if(ajax.readyState == 4 && ajax.status == 200){
				console.log(this.response); // Back-end값 출력
		}
	}

	ajax.open("POST","./ajax4.do",true);
	ajax.send(JSON.stringify(data)); // JSON의 배열 형태 Back-end에게 전달
}


