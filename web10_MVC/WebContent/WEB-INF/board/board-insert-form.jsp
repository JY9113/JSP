<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Insert Form</title>
</head>
<body>
<h1>새 글 작성 페이지</h1>
<form action="board-insert" method="post">
	<input type="text" name="title" placeholder="제목 입력" required/><br/>
	<textarea rows="5" cols="40" name="content" placeholder="본문을 작성하세요" required></textarea><br/>
	<input type="text" name="userid" placeholder="아이디를 넣으세요"/><br/>
	<input type="submit" value="작성 완료"/>
</form>
</body>
</html>