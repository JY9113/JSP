<%@page import="edu.web.model.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JSp</title>
</head>
<body>

<h1>EL(Expression Language)</h1>
<h2>EL 자료 타입</h2>
<%-- 숫자, 문자열, 논리형, 객체(Set, List, Map, ...) --%>
${n = 10.0 }<br/>
n = ${n }<br/>
${name = 'jy' }<br/>
이름: ${name }<br/>
<%-- EL은 문자열을 사용할 때 큰따옴표(""), 작은따옴표('') 모두 사용 가능 --%>

${1 != 2 }<br/>

<%-- EL Set: {e1, e2, e3, ...} 
Java의 HashSet<Object>에 해당 --%>
${set = {1, 2.0, 'hi', true, 1} }<br/>

<%--EL List : [e1, e2, e3, ...] 
Java의 ArrayList<Object>에 해당
--%>
${list = [ 1, 2.0, 'hi', true, 1 ]}<br/>
${list[1]}<br/>

<%-- EL Map : {k1: v1, k2 : v2, .... 
	Java의 HashMap<Object, Object>에 해당
--%>
${map = {1 : '하나', 'two' : '둘', 'key' : list }}<br/>
${map[1]}<br/>
${map['two'] }

<hr/>
<h2>EL 연산자</h2>
${1 + 2 * 3 / 4}<br/>
${1 eq 2 }<br/> <%--eq, == --%>
${1 ne 2 }<br/><%-- ne, != --%>
${1 div 2 }<br/><%-- div, / --%>
${1 mod 2}<br/><%-- mod, % --%>
<%--lt(<), gt(>), le(<=), ge(>=) --%>
<%--and(&&), or(||), not(!) --%>
<%-- 삼항 연산자 : (식) ? 값1 : 값2 --%>
${(123 gt 0) ? '양수' : '음수 또는 0' }<br/>
<hr/>
<h2>EL에서 객체 (Object) 사용</h2>

<%
	Contact c1 = new Contact("A", "010-1111-1111", "aa@gmail.com");
	request.setAttribute("contact1", c1);
// 	Contact c =(Contact) request.getAttribute("contact1");
// 	out.write("이름 : " + c.getName() + "<br/>\r\n");
%>

<%--EL은 JSP의 지역 변수는 직접 접ㄱ느 불가 - 단점
		JSP의 내장 객체(request, pagecontext, session,.....)의 attribute는 접근 가능
		내장 객체의 attribute에 저장된 타입이 객체(object)이면,
		그 멤버 변수들은 변수 이름만으로 접근 가능 - 단, getter 메소드가 있어야 함
 --%>
Name : ${contact1.name }<br/>
Phone : ${contact1.phone }<br/>
Email : ${contact1['email'] }<br/>

<hr/>
<h2>EL에서 람다 표현식 사용하기</h2>
<%--
	(x,y,....) -> { 실행문; }
--%>
${((x, y) -> x + y)(1, 2) }<br/>
${add = (x,y) -> x + y }<br/>
${add(10,20) }
<%--1 + 2 를 리턴하겠다 --%>
</body>
</html>







