<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>JSP</title>
</head>
<body>
<h1>&lt;fmt:setLocale&gt; 태그</h1>
<%-- Locale : 해당 국가에서 사용하는 언어를 설정(언어코드_국가코드) 
ko_KR : 한국어_대한민국
en_US : 영어_미국
en_GB : 영어_영국
ja_JP : 일본어_일본
zh_CN : 중국어_중국(간체, simplified chinese)
zh_TW : 중국어_대만(번체, traditional chinese)
de_DE : 독일어_독일
--%>

<fmt:setLocale value="zh_CN"/>
<fmt:formatNumber value="123456.789123"/><br/>
<fmt:formatNumber value="10000" type="currency"/><br/>
<c:set var="now" value="<%=new Date() %>"/><br/>
<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
</body>
</html>