<%@ page import="edu.web.model.Contact"%>
<%@ page import="java.util.ArrayList"%>
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

<%
ArrayList<Contact> contacts = new ArrayList<>();
contacts.add(new Contact("aaa", "010", "aaa@test.com"));
contacts.add(new Contact("bbb", "010", "bbb@test.com"));
contacts.add(new Contact("ccc", "010", "ccc@test.com"));
%>
<table>
	<thead>
		<tr>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
		</tr>
	</thead>
	<tbody>
		<% for (Contact c : contacts) { %>
		<tr>
			<td><%=c.getName() %></td>
			<td><%=c.getPhone() %></td>
			<td><%=c.getEmail() %></td>
		</tr>
		<% } %>
	</tbody>
</table>

<hr/>
<c:set var="contactList" value="<%=contacts %>" />
<table>
	<thead>
		<tr>
			<th>NO</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="c" items="${contactList }" 
			varStatus="status">
			<tr>
				<td>${status.index }</td>
				<td>${c.name }</td>
				<td>${c.phone }</td>
				<td>${c.email }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>





