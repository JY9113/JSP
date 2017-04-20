<%@page import="edu.web.model.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JSP</title>
</head>
<body>

<h1>JSTL 변수(property) 선언과 사용</h1>
<%-- 
웹 애플리케이션의 Scope(범위)와 JSP 내장 객체:
1. Page Scope: 하나의 JSP 페이지를 처리할 때 사용되는 범위
	PageContext pageContext
2. Request Scope: 하나의 요청(request)를 처리할 때 사용되는 범위
	HttpServletRequest request
3. Session Scope: 웹 브라우저가 실행 중에 유지가 되는 범위
	HttpSession session
4. Application Scope: 하나의 웹 애플리케이션이 실행 중에 유지되는 범위
	ServletContext application
각 범위(scope)에 해당하는 객체들은 값들을 저장하고 읽기 위한 메소드를 제공:
	setAttribute(attrName, object),
	getAttribute(attrName)

JSTL에서 변수 선언
<c:set var="변수이름" value="변수값" scope="범위" />
	JSTL에서 범위: page, request, session, application
	scope 속성을 지정하지 않으면 기본 범위는 page scope
--%>

<%
pageContext.setAttribute("name1", "오쌤");
%>
이름: <%=pageContext.getAttribute("name1") %><br/>

<c:set var="name2" value="아이티윌" />
<c:set var="name2" value="홍길동" scope="request" />
이름: ${name2 }<br/>
이름: ${pageScope.name2 }<br/>
request name2: ${requestScope.name2 }<br/>
<%-- 
EL의 동작 방식:
EL은 변수(property)의 값을 읽어올 때
pageScope -> requestScope -> sessionScope -> applicationScope
순으로 attribute를 찾음(getAttribute) 
--%>

<%-- <c:set> 사용해서 객체 선언/사용 --%>
<%
pageContext.setAttribute("c1", new Contact());
Contact contact = (Contact) pageContext.getAttribute("c1");
contact.setName("오쌤");
%>
<c:set var="c2" value="<%=new Contact() %>" />
<c:set target="${c2 }" property="name" value="홍길동" />
<c:set target="${c2 }" property="phone" value="010-1234-5678"/>
<c:set target="${c2 }" property="email" value="hgd@itwill.com"/>
${c2.name } <br/>
${c2.phone } <br/>
${c2.email } <br/>

<c:set var="c3" value="${c1 }" />
<c:set target="${c3 }" property="phone" value="010" />
이름: ${c3.name }<br/>
전화번호: ${c3.phone }<br/>

</body>
</html>







