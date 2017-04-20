<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Cookie</title>
</head>
<body>
<h1>쿠키 생성/전송</h1>
<%
	// 1. Cookie 객체 생성 : new Cookie(name, value)
	Cookie c1 = new Cookie("userid", "admin");
	// 2. Cookie 객체의 속성 설정
	//		setMaxAge(초단위) : 쿠키를 브라우저에서 저장할 시간(유효기간)
	//		-1을 주면 브라우저를 종료할때 쿠키를 만료시키겠다 	
	//		0을 주면 브라우저가 응답을 받는 순간 만료
	c1.setMaxAge(60 * 60); // 1 시간 
	c1.setHttpOnly(true);
	// 3. 쿠키 전송 : response.addCookie(cookie) : 생성한 쿠키를 전송
	response.addCookie(c1); 
	
	Cookie c2 = new Cookie("nickname", "AAA");
	c1.setMaxAge(30); // 쿠키를 30초동안만 유지하겠다
	response.addCookie(c2);
%>

<h2>쿠키 전송 성공</h2>
<a href="02_getCookie.jsp">생성된 쿠키 확인</a>
</body>
</html>