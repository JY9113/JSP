<%@page import="edu.web.contact.Contact"%>
<%@page import="java.util.ArrayList"%>
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
		}
		td {
			border : 1px dotted hotpink;
		}
	
	</style>
</head>
<body>
	<h1>scriptlet을 사용한 테이블 작성</h1>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>AAA</td>
				<td>01011111111</td>
				<td>aaa@gmail.com</td>
			</tr>
			<tr>
				<td>BBB</td>
				<td>01022222222</td>
				<td>bbb@gmail.com</td>
			</tr>
			<tr>
				<td>CCC</td>
				<td>01033333333</td>
				<td>ccc@gmail.com</td>
			</tr>
		</tbody>
		</table>
		<hr/>
		
		<%
			// ArrayList 선언, 생성
			ArrayList<Contact> list = new ArrayList<>();
			list.add(new Contact("D","01012341234","DD@gmail.com"));
			list.add(new Contact("E","01088888888","EE@gmail.com"));
			list.add(new Contact("F","01099999999","FF@gmail.com"));
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
				<%for(int i = 0; i < list.size(); i++) {	%>
				<tr>
					<td><%=list.get(i).getName()%></td>
					<td><%=list.get(i).getPhone()%></td>
					<td><%=list.get(i).getEmail()%></td>
				</tr>
				<%}	//end for %>
			</tbody>
		</table>
		
	
</body>
</html>