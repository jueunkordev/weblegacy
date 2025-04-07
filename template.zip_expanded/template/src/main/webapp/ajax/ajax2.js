// ajax => GET 통신
function ajax_gopage(){
	var ajax, result;
	
	var data = new Array();
	data[0] = "홍길동";
	data[1] = "강감찬";
	data[2] = "이순신";
	
	ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		if(ajax.readyState == 4 && ajax.status == 200){
				console.log(this.response); // Back-end값 출력
		}
	}
	ajax.open("POST","./ajax2.do",true);
	ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
	ajax.send("product="+data+"&person=hong");
}