<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="lang" value="${not empty param.lang ? param.lang : pageContext.request.locale }"/>
<fmt:setLocale value="${lang }"/>
<fmt:setBundle basename="edu.web.i18n.login_bundle"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>

<h1>&lt;fmt:setBundle&gt;</h1>
<form>
	<label><fmt:message key="login.bundle.id"/></label>
	<input type="text" name="userid"/><br/>
	<label><fmt:message key="login.bundle.pw"/></label>
	<input type="password" name="pwd"/><br/>
	<fmt:message key="login.bundle.login" var="btn_login"/>
	<input type="submit" value="${btn_login }"/>
</form>

</body>
</html>