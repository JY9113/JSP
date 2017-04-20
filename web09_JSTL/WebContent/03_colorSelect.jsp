<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JSP</title>

<style>
<c:if test="${param.color eq 'r'}">
	<c:set var="myColor" value="red" />
</c:if>
<c:if test="${param.color eq 'g'}">
	<c:set var="myColor" value="green" />
</c:if>
<c:if test="${param.color eq 'b'}">
	<c:set var="myColor" value="blue" />
</c:if>

body {
	background-color: ${myColor};
}
</style>

</head>
<body>

<h1>Color Select</h1>
<form action="03_colorSelect.jsp" method="get">
	<select name="color">
		<option value="r">빨강</option>
		<option value="g">초록</option>
		<option value="b">파랑</option>
	</select>
	<input type="submit" value="선택" />
</form>

</body>
</html>





