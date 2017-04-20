<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>
<h1>&lt;fmt:requestEncoding&gt; 태그</h1>
<form method="post">
	<input type="text" name="userName" placeholder="이름 입력하세요..."/>
	<br/>
	<input type="submit" name="submit" value="제출"/>
</form>
<hr/>
<%-- <% request.setCharacterEncoding("UTF-8"); %> --%>
<fmt:requestEncoding value="UTF-8"/>
이름 : ${param.userName }<br/>

</body>
</html>