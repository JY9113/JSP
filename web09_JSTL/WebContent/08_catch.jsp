<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h1>&lt;c:catch&gt; 태그</h1>
<c:catch var="error">
	예외 발생 전<br/>
	계산 1: ${123 / 0 }<br/>
	계산 2: <%=123 / 0 %><br/>
	출력이 될까요?<br/>
</c:catch>
에러 내용: ${error }<br/>

</body>
</html>





