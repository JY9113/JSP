<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Board</title>
</head>
<body>

<h1>새 글 작성 페이지</h1>
<form action="register" method="post">
	<input type="text" name="title" placeholder="글 제목 입력" 
		required autofocus />
	<br/>
	<textarea rows="5" cols="40" name="content" 
		placeholder="본문 작성" required></textarea>
	<br/>
	<input type="text" name="userid" placeholder="아이디"
		required />
	<br/>
	<input type="submit" value="작성 완료" />
</form>

</body>
</html>







