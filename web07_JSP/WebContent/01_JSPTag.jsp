<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"%>

<%--
	JSP 동작 원리 
		1. 런타임 시에 JSP 컴파일러에 의해서 JSP 파일이 자바 파일(.java)로 변환
			-> 이 자바 파일은 서블릿 클래스
		2. 자바 컴파일러가 자바 파일을 컴파일해서 클래스 파일(.class)을 생성
		3. JRE이 클래스 파일을 기계어로 번역해서 실행
			-> 요청(request, 응답(response)를 처리
--%>


<%--	JSP 주석
		
		JSP 구성요소(TAG)
		1. <%@ %> : Directive(지시자, 지시문)
						  JSP 페이지 전체에 대한 속성들을 설정
		2. <%! %> : Declaration(선언문)
						멤버변수, 메소드, 내부 클래스를 선언하는 부분
		3. <% %> : Scriptlet(스크립트릿)
						메소드 내부에서 실행되는 자바 코드를 작성하는 부분
						 (ex. 메소드(_jspService)
		4. <%= %> : Expression(표현식)
						  변수의 값, 메소드의 리턴 값 등을 프린트하는 용도
		5. Comment(주석)
						JSP 주석은 서블릿 클래스로 변환될 때 코드로 변환되지 않음!
						JSP 주석은 클라이언트(브라우저)로 전송되지 않음!
						Scriptlet이나 Declaration 내부의 자바 주석은 서블릿 클래스로 변환될 때 자바 주석으로 함께 변환 됨.
						
							
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>
<!-- HTML/XML 주석 -->
<h1>JSP Tag(구성요소)</h1>

<%-- Declaration (선언문) --%>
<%!
	public int add(int x, int y) {
		return x + y;	
	}
%>

<%-- Scriptlet --%>
<%
	// 지역 변수 선언
	int result = add(10, 20);
	
	// JSP에서 출력 방법
	// 	1) console 로그
	System.out.println("result = " + result);
	//		2) writer 객체를 사용해서 응답(response)으로 출력
	//			Servlet에서처럼 response.getWriter()를 호출하면 안됨!!!!!!
	//			JSP가 변환된 Servlet 클래스의 내장 객체인 out(getWriter()를 가지고 있는 객체)객체를 사용해서 프린트	
	out.write("<p>result = " + result + "</p>\r\n");	
%>

<%-- Expression(표현식) --%>
<p>결과값 = <%=result %></p>
<% 
Date date = new Date();  
%>



</body>
</html>