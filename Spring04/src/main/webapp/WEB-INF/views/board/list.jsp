<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Board</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<h1>게시판 메인 페이지</h1>
<c:if test="${empty login_id}">
	<button type="button" id="btn_login">로그인</button>
</c:if>
<c:if test="${not empty login_id}">
	${login_id}
	<button type="button" id="btn_logout">로그아웃</button>
</c:if>

<hr/>
<a href="register">새글작성</a>
<a href="test?data1=한글&data2=abc123def">로그인 필요한 메뉴</a>
<hr/>
<h2>게시판 글 목록</h2>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성 시간</th>
		</tr>
	</thead>
</table>

<script>
$(document).ready(function() {
	$('#btn_login').click(function() {
		// 상대 패스: 현재 위치를 기준으로 상대적으로 찾아가는 경로
		//location = '../member/login';
		
		// 절대 패스: context root부터 모든 경로
		//location = '/ex04/member/login';
	
		// 로그인 후에 다시 게시판 메인(list.jsp) 페이지로 돌아올 수 있도록
		var target = encodeURI('/ex04/member/login?url=' + location.href);
		console.log(target);
		location = target;
	});
	
	$('#btn_logout').click(function() {
		location = '../member/logout';
	});
});
</script>

</body>
</html>







