<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Member</title>
</head>
<body>
<h1>회원 정보 상세 페이지</h1>
<form action="member_update" method="get">
	<input type="text" name="userid" value="${memberVO.userid }" readonly/><br/>
	<input type="password" name="pwd" value="${memberVO.pwd }" readonly/><br/>
	<input type="email" name="email" value="${memberVO.email }" readonly/><br/>
	<input type="text" name="active" value="${memberVO.active }" readonly/><br/>
	<input type="submit" value="수정"/>
</form>

</body>
</html>