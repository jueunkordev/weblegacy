// ajax => GET 통신
function ajax_gopage(){
	var ajax, result;
	
	ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		if(ajax.readyState == 4 && ajax.status == 200){
				console.log(this.response); // Back-end값 출력
		}
	}
	ajax.open("","",true);
	ajax.setRequestHeader("");
	ajax.send();
}