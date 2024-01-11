<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입...</title>
<style>
	.content{margin-left: 30px;}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="content">
		<h2>회원 가입</h2>
		<form action="/member/join" method="post">
			<p>
				<input id="email" type="text" name="email"
					placeholder="이메일" onblur="checkEmail()">
			</p>
			<p id="check-result"></p>
			<p>
				<input type="password" name="password" placeholder="비밀번호">
			</p>
			<p>
				<input type="text" name="name" placeholder="이름">
			</p>
			<p>
				<input type="text" name="age" placeholder="나이">
			</p>
			<p>
				<input type="submit" value="가입">
				<input type="reset" value="취소">
			</p>
		</form>
	</div>
<script>
	//이메일 입력값을 가져오고, 입력값을 서버(컨트롤러)로 전송
	//ajax() -> 입력값을 서버(컨트롤러)로 전송
	//이메일이 체크된 후 사용 가능 여부를 입력상자 아래에 표시
	const checkEmail = function(){
		let email = document.getElementById("email").value
		let checkResult = document.getElementById("check-result")
		console.log("이메일: ", email)
		
		$.ajax({
			//요청방식, url, data, 함수 - (성공, 실패)
			type : "POST",
			url: "/member/checkmail",
			data:{
				email: inputEmail,
			},
			success: function(res){
				console.log("성공: ", res);
				if(res == "OK"){
					checkResult.innerHTMl = "사용가능한 이메일입니다.";
					checkResult.style.color = "green";
				}else{ //res == "no"
					checkResult.innerHTMl = "이미 가입된 이메일입니다.";
					checkResult.style.color = "red";
				}
			},
			success: function(err){
				console.log("실패: ", err);
			}
		})
	}
</script>
</body>
</html>