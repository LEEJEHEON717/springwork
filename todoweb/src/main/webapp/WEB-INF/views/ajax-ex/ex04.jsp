<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax-study</title>
<style>
	.content {margin-left: 30px;}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="content">
		<h2>4. POST 요청(DTO 전달)</h2>
		<p>
			<button type="button" onclick="myFunction()">전송</button>
		</p>
	</div>
<script>
	//Ajax는 제이쿼리 라이브러리를 임포트해야함
	//ajax 함수는 객체로 구성되고 형태는 {key: value}임
	const myFunction = function(){
		//alert("test...");
		let greeting = "축하합니다.";
		let number = 2024;
		$.ajax({
			//요청 방식: GET, 요청 주소: /ex01, (함수)-성공, 실패
			//자바스크립트 객체 - 키(key)값은 문자열로 함(자바스크립트에서는  "" 생략 가능하다.)
			type: "POST",
			url: "/ex04",
			data: {
				greet: greeting,
				num: number
			},
			success: function(res){ //res는 서버에서 보내주는 자료
				console.log("성공", res);
			},
			error: function(){
				console.log("실패");
			}
		});
	}
</script>
</body>
</html>