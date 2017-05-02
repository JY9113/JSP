<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Member</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>회원 등록 현황</h1>
<ul>
	<li><a href="member_insert">가입하기</a></li>
</ul>
<hr/>
<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${memberList }">
			<tr>
				<td><a href="member_detail?userid=${vo.userid }">${vo.userid }</a></td>
				<td>${vo.pwd }</td>
				<td>${vo.email }</td>
				<td>${vo.active }</td>			
			</tr>
		</c:forEach>	
	</tbody>	
</table>

<script>
	if('${member_inser_result}' === 'SUCCESS') {
		alert('멤버 등록 성공');
	} else if('${member_insert_result}' === 'FAIL'){
		alert('멤버 등록 실패');
	}
</script>

</body>
</html>