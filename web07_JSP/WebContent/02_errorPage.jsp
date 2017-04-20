<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage="error.jsp"%>
<%-- JSP를 실행하는 도중에 Exception이 발생하면 errorPage 속성에 지정된 페이지로 이동해라 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>
<h1>Directive를 사용한 에러 페이지 처리</h1>
<p>나눗셈 결과 : <%=(123/0) %></p>
</body>
</html>