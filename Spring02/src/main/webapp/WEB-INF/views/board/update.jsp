<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"
	uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Board</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<h1>게시글 수정 페이지</h1>
<form id="frm">
	<input type="hidden" name="page" value="${criteria.page }"/>
	<input type="hidden" name="perPage" value="${criteria.numsPerPage}"/>
	<label>글 번호</label><br/>
	<input type="text" name="bno" value="${boardVO.bno}"
		readonly />
	<br/>
	<label>글 제목</label><br/>
	<input type="text" value="${boardVO.title}"
		name="title" />
	<br/>
	<label>본문</label><br/>
	<textarea rows="5" cols="40" name="content">${boardVO.content}</textarea>
	<br/>
	<label>작성자 아이디</label><br/>
	<input type="text" value="${boardVO.userid}"
		readonly />
	<br/>
	<label>작성 시간</label><br/>
	<fmt:formatDate value="${boardVO.regdate}"
		pattern="yyyy-MM-dd HH:mm:ss" var="regdate" />
	<input type="text" value="${regdate}"
		readonly />
	<br/>
	
</form>

<button type="submit" id="btn_update">수정 완료</button>
<button type="submit" id="btn_delete">삭제</button>

<script>
$(document).ready(function() {
	var frm = $('#frm');
	
	$('#btn_update').click(function() {
		frm.attr('action', 'update');
		frm.attr('method', 'post');
		frm.submit();
	});
	
	$('#btn_delete').click(function() {
		frm.attr('action', 'delete');
		frm.attr('method', 'post');
		frm.submit();
	});
});
</script>

</body>
</html>








