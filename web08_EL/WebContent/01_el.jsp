<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Language) : 표현식 언어, 식 언어</h1>
<%-- HTML 형식 --%>
Hello, JSP!<br/>
<%-- Scriptlet 형식 --%>
<%
	out.write("Hello, JSP!<br/>");
%>
<%--Expression(표현식) --%>
<%="Hello, JSP!<br/>" %>

<%--EL (Expression Language) --%>
${"Hello, JSP!<br/>"}
</body>
</html>