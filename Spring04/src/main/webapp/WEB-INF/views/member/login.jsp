<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h1>로그인 폼</h1>
<!-- 
form에서 action의 주소 표시 방법:
1) 절대 경로: /ex04/member/login-post
2) 상대 경로: ./login-post 또는 login-post
상대 경로(패스)에서 .은 현재 폴더(위치)를 의미, ..는 상위 폴더를 의미 
 -->
<form action="./login-post" method="post">
	<input type="text" name="userid" placeholder="USER ID"
		required autofocus />
	<br/>
	<input type="password" name="pwd" placeholder="PASSWORD"
		required />
	<br/>
	<input type="hidden" name="targetUrl" value="${targetUrl }"/>
	<input type="submit" value="로그인" />
</form>

</body>
</html>