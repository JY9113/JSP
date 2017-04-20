<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Session</title>
</head>
<body>
<h1>세션 속성(attribute) 값 제거 / invalidate(무효화) </h1>
<%
	// 세션 attribute에 데이터 저장
	session.setAttribute("userid", "admin");
	session.setAttribute("age", 16);
	session.setAttribute("active", true);
	
	Enumeration<String> attrNames = session.getAttributeNames();
	while (attrNames.hasMoreElements()) {
		String name = attrNames.nextElement();
		out.println(name + "<br/>");
	}
	
	out.println("<hr/>id, age 속성 제거<br/>");
	session.removeAttribute("id");
	session.removeAttribute("age");
	
	attrNames = session.getAttributeNames();
	while (attrNames.hasMoreElements()) {
		String name = attrNames.nextElement();
		out.println(name + "<br/>");
	}
%>
</body>
</html>