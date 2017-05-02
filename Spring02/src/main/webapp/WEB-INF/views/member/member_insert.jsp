<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Member</title>
</head>
<body>
<form action="member_insert" method="post">
	<input type="text" name="userid" placeholder="아이디 입력"/><br/>
	<input type="password" name="pwd" placeholder="비밀번호 입력"/><br/>
	<input type="text" name="email" placeholder="이메일 입력"/><br/>
	<input type="submit" value="등록"/>
</form>

</body>
</html>