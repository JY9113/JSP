<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>
<h1>&lt;fmt:bundle&gt;와 &lt;fmt:message&gt;</h1>
<%--
	I18N(Internalization, 국제화) :
		전 세계의 언어를 지원할 수 있도록 SW를 제작하는 것
	L10N(Localization, 지역화) : 
		해당 지역의 언어로 SW를 번역하는 것
		
	웹 애플리케이션에서 I18N/L10N을 지원하는 방법 :
		1) 리소스 파일을 작성하고 자바 패키지에 포함 : 파일이름_로케일.properties
		2) <fmt:bundle> 태그의 basename 속성에 리소스 파일 이름 설정
		3) <fmt:message> 태그의 key 속성에 사용할 문자열 키를 지정
 --%>
<%--  <fmt:setLocale value="zh_CN"/> --%>
<fmt:bundle basename="edu.web.i18n.login_bundle">
<form>
	<label><fmt:message key="login.bundle.id"/></label>
	<input type="text" name="userid"/><br/>
	<label><fmt:message key="login.bundle.pw"/></label>
	<input type="password" name="pwd"/><br/>
	<fmt:message key="login.bundle.login" var="btn_login"/>
	<input type="submit" value="${btn_login }"/>
</form>
</fmt:bundle>
</body>
</html>