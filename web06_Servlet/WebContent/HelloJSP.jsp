<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h2>안녕, JSP!</h2>
<%
	// Java 코드
	Date curDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
	String dateString = sdf.format(curDate);
%>

<h2>현재 시간 : <%=dateString%></h2>

</body>
</html>