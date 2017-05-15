<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<% System.out.println("home.jsp 호출"); %>

<c:if test="${not empty login_id}">
<%-- not empty: not null && 빈 문자열("") 아님 --%>
${login_id}님, 환영합니다!<br/>
<button id="btn_logout" type="button">로그아웃</button>
</c:if>
<c:if test="${empty login_id}">
	<form action="member/login-post" method="post">
		<input type="text" name="userid" 
			placeholder="USER ID" required autofocus />
		<input type="password" name="pwd"
			placeholder="PASSWORD" required />
		<input type="submit" value="로그인" />
	</form>
</c:if>

<hr/>
<a href="board/list">게시판 메인</a>

<script>
$(document).ready(function() {
	if ('${login_fail}' === 'fail') {
		// 로그인 실패 정보가 서버로부터 전달됨
		alert('아이디 또는 비밀번호가 일치하지 않습니다.');
	}
	
	$('#btn_logout').click(function() {
		// 콘트롤러 메소드에 매핑된 ULR 호출
		location = 'member/logout';
	});
});
</script>

</body>
</html>






