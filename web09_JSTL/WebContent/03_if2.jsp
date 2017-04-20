<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
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

.hello {
	color: ${myColor};
}
</style>
</head>
<body>

<h1>c:if와 EL 활용</h1>
<div class="hello">안녕하세요....</div>


</body>
</html>