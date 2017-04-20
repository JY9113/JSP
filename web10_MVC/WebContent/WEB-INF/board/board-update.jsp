<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Board</title>
<style>
	table {
		width : 100%;
		border : 1px dashed pink;
		border-collapse : collapse;
		text-align : center;
	}
	.mainContent {
		width : 50%;
		margin-left : 25%;
	}
	hr {
		border-color : hotpink;
	}
</style>
</head>
<body>
<div class="mainContent">
	<h1> 게시글 수정 페이지</h1>
	<ul>
		<li><a href="board-main">전체 목록</a></li>
		<li><a href="board-detail?bno=${boardVO.bno }">상세 페이지</a></li>
		<li><a href="board-delete?bno=${boardVO.bno }">삭제</a></li>
	</ul>
	<hr/>
	
	<form action="board-update" method="post">
		<input type="text" name="bno" value="${boardVO.bno }" style="display:none"/>
		<label for="title">글 제목</label>
		<br/>
		<input type="text" id="title" name="title" value="${boardVO.title }"/>
		<br/>
		<label for="content">글 내용</label>
		<br/>
		<textarea rows="5" cols="40" id="content" name="content" >${boardVO.content }</textarea>
		<br/>
		<label for="userid">작성자 아이디</label>
		<br/>
		<input type="text" id="userid" name="userid" value="${boardVO.userid }" readonly/>
		<br/>
		<label for="regdate">작성 시간</label>
		<br/>
		<fmt:formatDate var="rdate" value="${boardVO.regdate }" pattern="yyyy-MM-dd HH:mm"/>
		<input type="text" id="regdate" name="regdate" value="${rdate }" readonly/>
		<input type="submit" value="수정완료"/>
	</form>
</div>
</body>
</html>