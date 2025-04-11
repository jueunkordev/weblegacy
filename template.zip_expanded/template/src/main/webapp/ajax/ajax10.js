export class ecma_ajax{
	// 배열 생성 후 POST 전송
	ajax_arr(){
		//this.arr = {mid:"hong",mname:"홍길동"};
		fetch("./ajax11.do",{
			method : "POST",
			/*
			Backend : @RequestBody
			headers : {"content-type":"application/json"}, => JSONArray, JSONObject
			body : JSON.stringify(this.arr)
			
			Backend : @RequestParam @@ModelAttribute
			headers : {"content-type":"application/x-www-form-urlencoded"},
			 body : "mid=hong&mname=홍길동"
			*/
			// URLSearchParams : 키배열, 원시배열을 구성하여 Ajax로 데이터 전송시키는 방식
			headers : {"content-type":"application/x-www-form-urlencoded"},
         body : new URLSearchParams({ 
            mid : "hong",
            mname : "홍길동",
            mage : 25
         })
		}).then(function(aa){ // Back-end에서 결과값을 받는 함수
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