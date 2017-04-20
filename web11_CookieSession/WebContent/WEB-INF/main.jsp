<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Session</title>
</head>
<body>

<h1>메인 페이지</h1>
<!--  userid 가 null이 아닌 경우 -->
<c:if test="${not empty userid }">
<%-- userid 속성이 null이 아니고, 빈 문자열("")도 아닌 경우 : 로그인 상태--%>
	${userid}님, 환영합니다......*^^*

</c:if>
<!--  userid 가 null인 경우 -->
<c:if test="${empty userid }">
<%-- userid 속성이 null이 아니고, 빈 문자열("")도 아닌 경우 : 로그아웃 상태--%>
	<a href="login">로그인</a>
</c:if>

<hr/>
<h2>여기는 본문입니다...</h2>

</body>
</html>





