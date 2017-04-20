<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JSP</title>
</head>
<body>

<h1>&lt;fmt:formatDate&gt; 태그</h1>
<c:set var="now" value="<%=new Date() %>" />
현재 시간: <c:out value="${now }" /><br/>
기본값 : <fmt:formatDate value="${now }"/><br>
Date : <fmt:formatDate value="${now }" type="date"/><br/>
Time : <fmt:formatDate value="${now }" type="time"/><br/>
Both : <fmt:formatDate value="${now }" type="both"/><br/>

<h2>date Style, timeStyle 속성</h2>
Long : <fmt:formatDate value="${now }" type="both" dateStyle="Long" timeStyle="Long"/><br/>
Short : <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/><br/>
Full : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br/>

<h2>pattern 속성</h2>
<fmt:formatDate value="${now }" pattern="yyyy/MM/dd hh:mm:ss"/>
</body>
</html>
