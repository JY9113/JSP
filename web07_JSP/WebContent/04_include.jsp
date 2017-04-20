<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Insert title here</title>
<style>
	.footer {
		background-color : pink;
		color : hotpink;
		font-weight : bold;
		text-align : right;
		height : 60px;
		font-size : 150%;
	}
</style>
</head>
<body>
<%-- header 파일을 include --%>
<%@ include file="header.jspf"%>
<h1>include Directive(지시자)</h1>
<div>
	<p>본문입니다....</p>
</div>

<%--footer 파일을 include --%>
<%@ include file="footer.jspf"%>
<%--
include 지시자 (directive) 동작 원리
include를 사용해서 다른 파일(jsp, jspf)을 포함시키면
하나의 JSP 파일로 합쳐진 이후에, 서브릿 클래스로 변환
 --%>
</body>
</html>