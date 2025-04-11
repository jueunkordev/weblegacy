document.querySelector("#btn").addEventListener("click",function(){
	new myinfos().ajax_data();
});

// var, let, const(상수)

export class myinfos{
	ajax_data(){
		// 사용자가 입력한 아이디값을 가져오는 코드
		let mid = document.querySelector("#mid").value;
		this.arr = new Array(); // 빈 배열을 생성
		this.arr[0] = mid; // 배열에 아이디를 적용
		this.arr[1] = "apink@nate.com"; // 이메일
		this.arr[2] = "01010041004"; // 전화번호
		this.arr[3] = "서울시 종로구"; // 주소
		
		fetch("./ajax12.do/patch_myinfo",{
			method : "PATCH",
			headers : {"content-type":"application/json"},
			body : JSON.stringify(this.arr),
			
		}).then(function(aa){ // Back-end에서 결과값을 받는 함수
			return aa.text(); // text(), json() => JSON.parse()
		})
		.then(function(bb){ // Front-end에서 return된 결과 함수를 출력하는 함수
			console.log(bb);
		});
	}
}