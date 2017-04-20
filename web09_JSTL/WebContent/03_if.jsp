<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JSP</title>
</head>
<body>

<h1>색상 선택 결과</h1>
<%
String color = request.getParameter("color");
if (color.equals("r")) {
%>
<div style="color: red;">빨강</div>
<% } else if (color.equals("g")) { %>
<div style="color: green;">초록</div>
<% } else if (color.equals("b")) { %>
<div style="color: blue;">파랑</div>
<% } else { %>
<div>몰라요~</div>
<% } %>

<hr/>
<h2>&lt;c:if&gt; 사용 방법</h2>
<c:if test="${param.color eq 'r' }">
	<div style="color: red;">빨강</div>
</c:if>
<c:if test="${param.color eq 'g' }">
	<div style="color: green;">초록</div>
</c:if>
<c:if test="${param.color eq 'b' }">
	<div style="color: blue;">파랑</div>
</c:if>

</body>
</html>







