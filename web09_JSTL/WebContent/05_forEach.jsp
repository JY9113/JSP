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

<h1>&lt;c:forEach&gt; 태그</h1>
<% for (int i = 1; i <= 10; i++) { %>
	<%=i %><br/>
<% } %>

<hr/>
<c:forEach var="num" begin="2" end="5" varStatus="status">
	${status.index}, ${num }<br/>
</c:forEach>

<hr/>
<c:forEach var="num" begin="1" end="10" step="2">
	${num }<br/>
</c:forEach>

<hr/>
<%
String[] movies = {"Abc", "Def", "Ghi", "Jkl"};
%>
<ul>
<% for(String m : movies) { %>
	<li><%=m %></li>
<% } %>
</ul>

<hr/>
<c:set var="movieList" value="<%=movies %>" scope="request" />
<ul>
	<c:forEach var="movie" items="${movieList }">
		<li>${movie }</li>
	</c:forEach>
</ul>
</body>
</html>








