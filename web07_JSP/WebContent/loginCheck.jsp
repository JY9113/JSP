<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>
<%-- JSP 내장 객체 :
	JSP 파일이 서블릿 클래스로 변환됐을 때
	_jspService() 메소드가 가지고 있는 지역 변수들
	(예) request, response, session, application, page...
 --%>
 <%! // 선언문(Declaration) : 멤버 변수, 메소드, 내부 클래스 
 	private static final String ADMIN_ID = "admin";
 	private static final String ADMIN_PW = "1234";
 %>
 <%
 	// 요청 파라미터(request parameter)의 값들을 읽어옴
 	String id = request.getParameter("userid");
 	String pw = request.getParameter("userpw");
 	System.out.println("id = " + id + " pw = " + pw);
 	
 	// DB 연결, 아이디/패스워드 일치 체크, 체크 결과에 따라서 해당 페이지 로드
 	if (id.equals(ADMIN_ID) && pw.equals(ADMIN_PW)) {
 		// 로그인 성공
//  		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
//  		dispatcher.forward(request, response);
		response.sendRedirect("main.jsp?userid=" + id);
 	} else {
 		// 로그인 실패
 		response.sendRedirect("07_loginForm.jsp?userid=" + id);
 	}
 %>
</body>
</html>