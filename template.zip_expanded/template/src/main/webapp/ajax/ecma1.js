document.querySelector("#btn").addEventListener("click",function(){
	new box2().abc("kim");
	new box2().bbb();
	
});

class box{ // 클래스
	abc(data){ // 메소드
		this.msg =  "데이터 확인 : " + data;
		console.log(this.msg);
	}
}

class box2 extends box{
	bbb(){
		console.log("상속받은 클래스 bbb 메소드");
	}
}