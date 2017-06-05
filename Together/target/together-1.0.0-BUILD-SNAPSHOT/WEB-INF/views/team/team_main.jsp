<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--bootstrap-->
<!-- 모바일 디바이스에서  터치, 줌 등을 지원하기 위해서-->
<meta name="viewport" content="width=device-width, initail-scale=1">
<!--Bootstrap 최신 버전의 css 파일들을 링크-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- jQuery 최신 버전의 js 파일들을 링크 -->
<script   src="https://code.jquery.com/jquery-3.2.1.min.js"   integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="  crossorigin="anonymous"></script>
<!-- Bootstrap을  이용하기  위한 최신 버전의 js 파일들을 링크-->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="margin:5%">
<%@ include file="../header.jsp" %>
<article >
	<table height=700px class="table">
		<tr>
				<th width=200px style="border-right: 1px solid #b4b4b4">
				<br/>
					<form>
						<select class="form-control" id="team">
							<option>웅진</option>
							<option>팀2</option>
						</select>
					</form><br/><br/>
					<!-- TODO: 띄울 페이지 pageName 에 따라 메뉴가 바뀌어 보일 예정 -->
					<c:if test=" ${empty pageName }">
						<ul>
							<a href=""><li>공지사항</li></a>
							<a href=""><li>회사 일정</li></a>
						</ul>
					</c:if>
					<c:if test="${not empty pageName }">
						<ul>
							<a href=""><li>공지사항</li></a>
							<a href=""><li>팀 일정</li></a>
							<a href=""><li>파일 공유</li></a>
						</ul>
					</c:if>
				</th>
				<td>
					<h1> 팀 메인</h1>
				</td>
			</tr>
	</table>
</article>
<hr/>
<%@ include file="../footer.jsp" %>
</div>
</body>
</html>