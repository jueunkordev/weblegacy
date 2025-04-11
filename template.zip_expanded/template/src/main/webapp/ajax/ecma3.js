// addEventListener : 이벤트 핸들링 함수, 페이지 로드 시 무조건 작동하는 함수
document.querySelector("#btn").addEventListener("click",function(){
	// frm.search.value
	// querySelector : id(#), class(.)를 위주로 오브젝트 로드할 수 있음
	let search = document.querySelector("#mid").value;
	console.log(search);
	new logins.search_ck(search);
});

export class logins{ // 외부로 호출할 수 있는 class
	constructor(){
		console.log("테스트입니다.");
	}
	agree_data(a,b){ // setter
		this.data = a;
		this.data2 = b;
	}
	get agree_data(){ // getter  (get을 사용하는 메소드)
		return this.data;
	}
	search_ck(word){
		if(word==""){
			alert("검색어를 입력하세요"); // GET
		}
		else{
			location.href="www.nate.com"; // GET
		}
	}

	zzz(){ // method
		let data = new Array();
		data[0] = "a1";
		data[1] = "a2";
		console.log("logins");
		console.log(data);
	}
}