export function api_select() {
	fetch("./api_select.do?key=apink", {
		method: "GET"
	}).then(function(aa) {
		return aa.json(); // text() : 문자열, json() = JSON.parse 사용과 동일
	}).then(function(bb) {
		// forEach, for in (ECMA), Jquery (forEach, Each, for in)
		// forEach, Map (React)
		let ea = bb["data_all"].length;
		bb["data_all"].forEach(function(a, b, c) { // a : 배열 데이터, b : 배열 그룹 번호, c : 전체 배열
			//console.log("a:"+a["pd1"]);
			// innerHTML로 배열값을 웹페이지에 출력하는 코드
			document.querySelector("#table_view").innerHTML+= `
			<tr>
				<td>`+Number(ea-b)+`</td>
				<td>`+a["pd1"]+`</td>
				<td>`+a["pd2"]+`</td>
				<td>`+a["pd3"]+`</td>
				<td>`+a["pd4"]+`</td>
				<td>`+a["pd5"]+`</td>
			</tr>
			`
		});
	}).catch(function(error) {
		console.log(error);
	});
}