<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"
	uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Board</title>
</head>
<body>

<h1>게시글 상세 보기 페이지</h1>
<form action="update" method="get">
	<input type="hidden" name="page" value="${criteria.page}"/>
	<input type="hidden" name="perPage" value="${criteria.numsPerPage }"/>
	<label>글 번호</label><br/>
	<input type="text" name="bno" value="${boardVO.bno}" readonly />
	<br/>
	<label>글 제목</label><br/>
	<input type="text" value="${boardVO.title}" readonly />
	<br/>
	<label>본문</label><br/>
	<textarea rows="5" cols="40" readonly>${boardVO.content}</textarea>
	<br/>
	<label>작성자 아이디</label><br/>
	<input type="text" value="${boardVO.userid}"
		readonly />
	<br/>
	<label>작성 시간</label><br/>
	<fmt:formatDate value="${boardVO.regdate}"
		pattern="yyyy-MM-dd HH:mm:ss" var="regdate" />
	<input type="text" name="regdate" value="${regdate}" readonly />
	<br/>
	<input type="submit" value="수정"/>
</form>
</body>
</html>






