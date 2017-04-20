<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr/>
	<form action="member-insert" method="post">
		<input type="text" name="userid" placeholder="아이디를 입력하세요"/><br/>
		<input type="password" name="pwd" placeholder="비밀번호를 입력하세요"/><br/>
		<input type="email" name="email" placeholder="이메일을 입력하세요"/><br/>
		<input type="text" name="username" placeholder="이름을 입력하세요"/><br/>
		<input type="submit" value="회원가입"/>		
	</form>
			
</body>
</html>