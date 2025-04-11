// 버튼 클릭 시 클래스 및 메소드를 호출
document.querySelector("#btn").addEventListener("click",function(){
	new ajax_network().ajax_get();
});

document.querySelector("#btn2").addEventListener("click",function(){
	new ajax_network2().ajax_idck();
});

// POST - Ajax
export class ajax_network2{
	ajax_idck(){
		this.userid = "hong";
		this.mid = "mid="+this.userid; // name 형태로 Back-end로 POST 전송
		fetch("./ajax10.do",{
			method : "POST",
			headers:{"content-type":"application/x-www-form-urlencoded"}, // headers를 이용하여 UTF-8
			body : this.mid // body는 POST 전송 시에 무조건 사용하게 됨
		}).then(function(aa){
			return aa.text();
		}).then(function(bb){
			console.log(bb);
		})
		.catch(function(error){
			console.log(error);
		})
	}
}


// GET - Ajax
export class ajax_network{
	ajax_get(){
		this.mid = "홍길동";
		// fetch  :ECMA에서부터 사용을 했으며, XMLHttpRequest => fetch로 변환
		fetch("./ajax9.do?mid="+this.mid)
		.then(function(aa){ // Back-end에서 결과값을 받는 함수
			return aa.text(); // text(), json() => JSON.parse()
		})
		.then(function(bb){ // Front-end에서 return된 결과 함수를 출력하는 함수
			console.log(bb);
		})
		.catch(function(error){ // 예외처리로 오류발생시 출력되는 역할
			console.log(error);
		})
	}
}