<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Session</title>
</head>
<body>
<h1>세션 정보 확인</h1>
<%
	// casting 안해주면 에러 발생. attribute의 object는 모든 타입이 가능하므로
	String id1 = (String)request.getAttribute("id");
	String id2 = (String)session.getAttribute("id");
	
	out.println("id1 = " + id1 + "<br/>id2 = " + id2);
%>
</body>
</html>