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

<h1>&lt;c:remove&gt; 태그</h1>
<%-- 
<c:set> 태그를 사용해서 attribute에 설정한 property(변수)를 삭제
--%>
<c:set var="age" value="16" />
<c:set var="age" value="17" scope="request"/>
<%-- pageContext.setAttribute("age", 16); --%>
age: ${age }<br/>

<%-- <c:remove>에서 scope 속성을 지정하지 않으면,
pageContext, request, session, application 범위 모두에서
해당 attribute를 삭제 --%>
<%-- <c:remove var="age" /> --%>
<c:remove var="age" scope="page"/>
remove 후 age: ${age }<br/>

</body>
</html>






