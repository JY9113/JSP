<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 
	page 지시자(directive)에서 contentType 속성을 설정하는 것은
	response.setContentType("text/html; charset=UTF-8");
	을 호출하는 것과 동일
	위에서 한 문장으로 호출하는 것은 아래의 두 문장을 실행하는 것과 동일
	response.setContentType("text/html");
	response.setCharacterEncoding("UTF-8");
	
	page 지시자에서 pageEncoding 속성을 설정하는 것은
	response.setCharacterEncoding("UTF-8");
	을 호출하는 것과 동일
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>
<h1>로그인 양식</h1>
<form action="loginCheck.jsp" method="post">
<%
	String id = request.getParameter("userid");
	if (id == null) {	// loginCheck 까지 갔다가 왔으면 null 이아니다
%>
<input type="text" name="userid" placeholder="ID"/>
<% 
	} else { 
%>
<input type="text" name="userid" placeholder="ID" value=<%=id%>><br/>
<div style="color:red">아이디, 비밀번호를 확인해 주세요</div>
<%}%>
	<input type="password" name="userpw" placeholder="비밀번호를 입력하세요"/><br/>
	<br/>
	<input type="submit" name="submit" value="LogIn"/>	
</form>
</body>
</html>