<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
	uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h1>&lt;fmt:formatNumber&gt; 태그</h1>
<fmt:formatNumber value="1234567890.123456789" />
<br/>
<fmt:formatNumber value="1234567890.123456789"
	groupingUsed="false" />
<br/>
<fmt:formatNumber value="1234567890.123456789"
	maxFractionDigits="5" />
<br/>
<fmt:formatNumber value="0.51" type="percent" />
<br/>
<fmt:formatNumber value="1234" type="currency" />

</body>
</html>







