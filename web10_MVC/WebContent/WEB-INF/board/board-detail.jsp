<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Board</title>
<style>
	.mainContent {
		width : 50%;
		margin-left : 25%;
	}
	hr {
		border-color : hotpink;
	}
	form {
		width : 100%;
	}
</style>
</head>
<body>
<div class="mainContent">
	<h1>게시글 상세 보기</h1>
	<ul>
		<li><a href="board-main">전체 목록</a></li>
		<li><a href="board-update?bno=${boardVO.bno}">수정</a></li>

	</ul>
	<hr/>
	<form>
		<label for="title">글 제목</label>
		<br/>
		<input type="text" id="title" name="title" value="${boardVO.title }" readonly/>
		<br/>
		<label for="content">글 내용</label>
		<br/>
		<textarea rows="5" cols="40" id="content" name="content" readonly>${boardVO.content }</textarea>
		<br/>
		<label for="userid">작성자 아이디</label>
		<br/>
		<input type="text" id="userid" name="userid" value="${boardVO.userid }" readonly/>
		<br/>
		<label for="regdate">작성 시간</label>
		<br/>
		<fmt:formatDate var="regdate" value="${boardVO.regdate }" pattern="yyyy-MM-dd HH:mm"/>
		<input type="text" id="regdate" name="regdate" value="${regdate }" readonly/>
	</form>

</div>
</body>
</html>