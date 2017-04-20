<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>
<h1>계산 결과</h1>
<h2>JSP 요소만 사용</h2>
<%
	double x = Double.parseDouble(request.getParameter("x"));
	double y = Double.parseDouble(request.getParameter("y"));
	double add = x + y;	
%>

<%=x %> + <%=y %> = <%= x + y%><br/>
<hr/>

<%--
	EL에서 요청 파라미터(request parameter)의 값을 읽으려면
	${param.name} 또는 ${param['name']}
 --%>
 ${param.x} + ${param.y } = ${param.x + param.y }<br/>
 ${param.x} / ${param.y } = ${param.x / param.y }<br/>
</body>
</html>