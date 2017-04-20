<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
<style>
	table, th {
		border : 1px solid hotpink;
		border-collapse : collapse;
	}
</style>
</head>
<body>
<h1>Scriplet 연습</h1>
<%-- Scriptlet 안에서 for 문을 사용해서 2,3,4 구구단 --%>
<table>
	<thead>
	<tr>
		<th colspan="8"> 구구단 테이블</th>
	</tr>
	</thead>
	<tbody>
		<%for(int j = 1; j < 10; j++) { %>
			<tr>
				<td><%=(j+1) * j %></td>
				<td><%=(j+2) * j %></td>
				<td><%=(j+3) * j %></td>
				<td><%=(j+4) * j %></td>
				<td><%=(j+5) * j %></td>
				<td><%=(j+6) * j %></td>
				<td><%=(j+7) * j %></td>
				<td><%=(j+8) * j %></td>
			</tr>
		<%} %>
	</tbody>
</table>

<hr/>
<table>
	<thead>
	<tr>
		<th colspan="8"> 구구단 테이블</th>
	</tr>
	</thead>
	<tbody>
		<%for(int j = 1; j < 10; j++) { %>
		<tr>
			<%for(int i = 2; i < 10; i++) {%>
					<td><%=(j) * i %></td>
			<%} %>
		</tr>
		<%} %>
	</tbody>
</table>


</body>
</html>