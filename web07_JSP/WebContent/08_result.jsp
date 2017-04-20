<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>
<h1>Form 양식 제출 데이터 확인</h1>
<%	// Scriptlet - _jspService() 메소드 내부에서 실행되는 코드
		// POST 방식인 경우, 요청 파라미터의 한글 처리를 위해서는
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("user_name");
int age = Integer.parseInt(request.getParameter("user_age"));
// 라디오 버튼 -> getParameter() 호출하고 null 체크
String mailReceive = request.getParameter("mail_receive");
// 체크 박스 : 
// 	1) 폼에서 체크박스들 중에서 선택된 버튼이 하나도 없으면
// 		요청 파라미터가 전달되지 않음 -> null 체크가 필요
//		2) 하나의 파라미터 이름으로 여러개의 값들이 전달될 수 있음
//			->getParametervalues() 메소드를 사용
String[] hobby = request.getParameterValues("hobby");
//	단일 선택 drop-down 리스트
String email = request.getParameter("email");
%>

이름 : <%=name %><br/>
나이 : <%=age %><br/>
메일 수신  : <%=mailReceive %><br/>
취미 : 
<%
	if (hobby != null) {
		for(int i = 0; i < hobby.length; i++) {
			if(i == (hobby.length-1)) {
				out.write(hobby[i]);
			} else {
				out.write(hobby[i] + ", ");
			}
		}
	} else {
		out.write("없음\r\n");
	}
%><br/>
이메일 : <%=email%>
<%
	// request 객체에서 파라미터의 이름들만 찾고자 할 때 : getParameterNames()
	Enumeration<String> paraNames = request.getParameterNames();
	while(paraNames.hasMoreElements()) {
		out.write(paraNames.nextElement() + " ");		
	}
%>


</body>
</html>