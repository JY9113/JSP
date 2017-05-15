<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>새 글 작성</title>
</head>
<body>
<h1>새 글 작성</h1>
	<form>
		<input type="text" name="title" placeholder="제목 입력" required autofocus/>
		<br/>
		<textarea rows="5" cols="40" name="content" required></textarea>
		<br/>
		<input type="text" name="userid" value="${login_id}" readonly/>
		<br/>
		<input type="submit" value="작성완료"/>
	</form>
</body>
</html>