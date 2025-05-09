document.querySelector("#hpmodify").addEventListener("click", function() {
	// 해당 연락처 수정 버튼을 클릭 시 연락처 입력 부분을 수정할 수 있도록 disable 정지시킴
	if (confirm("연락처를 수정하시겠습니까?")) {
		document.querySelector("#MHP").disabled = false;
	}
});

// 이메일 수정 시 적용되는 이벤트 핸들링
document.querySelector("#mailmodify").addEventListener("click", function() {
	if (confirm("연락처를 수정하시겠습니까?")) {
		document.querySelector("#MEMAIL").disabled = false;
	}
});
// 배열 키 : MAPSS(패스워드), MEMAIL(이메일), MPH(연락처)

// 개인정보 수정 버튼 클릭시 AJAX 발동
document.querySelector("#modify_myinfo").addEventListener("click", function() {
	// Map 배열로 키를 생성하여 전달하는 방식, Spring에서는 언어셋 기준으로 처리하지 못함
	/*
	let udata = new Map();

	udata.set("MID", document.querySelector("#MID").value);
	//값이 null이면 에러나기때문에 핸들링 필요 
	if (document.querySelector("#MPASS").value != "") {
		udata.set("MPASS", document.querySelector("#MPASS").value);
	}
	udata.set("MHP", document.querySelector("#MHP").value);
	udata.set("MEMAIL", document.querySelector("#MEMAIL").value);
	console.log(udata);
	*/
	

	fetch("./myinfo_modify.do/mykey", {
		method: "PATCH",
		headers: { "content-type": "application/json" },
		body: JSON.stringify({
			"MID" : document.querySelector("#MID").value,
			"MPASS" : document.querySelector("#MPASS").value,
			"MHP" : document.querySelector("#MHP").value,
			"MEMAIL" : document.querySelector("#MEMAIL").value
		})
	}).then(function(result) {
		return result.text();
	}).then(function(data) {
		console.log(data);
	}).catch(function(error) {
		console.log(error);
	});
});