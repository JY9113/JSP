<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Board</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
	ul {
		list-style-type : none;
	}
	li {
		display : inline-block;
	}
</style>
</head>
<body>

<h1>게시판 메인 페이지</h1>

<%-- 
URL 상대 경로(register): 현재 JSP가 있는 폴더 위치에서 상대적인 경로
	=> localhost:8181/ex02/board/register
URL 절대 경로(/register): 서버 주소에서 시작하는 경로
	=> localhost:8181/register
--%>
<ul>
	<li><a href="register">새 글 작성</a></li>
	<li><a href="../member/member_insert">가입하기</a>
</ul>

<hr/>
<table>
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>시간</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${boardList}">
		<tr>
			<td>${vo.bno}</td>
			<td><a class="goToDetail" href="${vo.bno}">${vo.title}</a></td>
			<td>${vo.userid}</td>
			<fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd HH:mm:ss" var="regdate" />
			<td>${regdate}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<ul class="pagination">
	<c:if test="${pageMaker.hasPrev }">
		<li><a href="${pageMaker.startPageNo-1 }">이전</a></li>
	</c:if>
	<c:forEach begin="${pageMaker.startPageNo}" end="${pageMaker.endPageNo }" var="num">
		<li><a href="${num }">${num }</a></li>
	</c:forEach>
	<c:if test="${pageMaker.hasNext }">
		<li><a href="${pageMaker.endPageNo+1 }">다음</a></li>
	</c:if>
</ul>
<form id="pagingForm" style="display:none;">
	<input type="text" name="page" value="${pageMaker.criteria.page }"/>
	<input type="text" name="perPage" value="${pageMaker.criteria.numsPerPage }"/>
	<input type="text" name="bno"/>
</form>
<script>
$(document).ready(function() {
	$('.pagination li a').click(function() {
		// a 태그의 기본 동작(페이지 이동)을 금지
		event.preventDefault();
		var targetPage = $(this).attr('href');
		var frm = $('#pagingForm');
		frm.find('[name="page"]').val(targetPage);
		frm.attr('action', 'list');
		frm.attr('method', 'get');
		frm.submit();
	});
	
	$('.goToDetail').click(function() {
		event.preventDefault();
		var bno = $(this).attr('href');
		var frm = $('#pagingForm');
		frm.attr('action', 'detail');
		frm.attr('method', 'get');
		frm.find('[name="bno"]').val(bno);
		frm.submit();		

	});
	
	if ('${insert_result}' === 'success') { 
		alert('새 글 작성 성공');
	} else if ('${insert_result}' === 'fail') {
		alert('새 글 작성 실패');
	}
	
});
</script>

</body>
</html>