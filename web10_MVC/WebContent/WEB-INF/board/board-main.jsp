<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1 style="text-align:center">게시판 메인 페이지</h1>
	<ul> 
		<li><a href="board-insert">새글 작성</a></li>
	</ul>
	<hr/>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
			</tr>
		</thead>
		<tbody>
			<%-- request에서 setAttribute한 값을 불러온다 --%>
			<c:forEach var="vo" items="${boardList }">
				<tr>
					<td>${vo.bno }</td>
					<td><a href="board-detail?bno=${vo.bno }">${vo.title }</a></td>
					<td>${vo.userid }</td>
					<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd HH:mm"/></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
		
	</table>
</div>

</body>
</html>