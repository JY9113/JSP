<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
1) JSTL 라이브러리를 프로젝트 추가: 
	WebContent/WEB-INF/lib/taglib-1.2.x.jar
2) JSP 파일에서 필요한 JSTL 라이브러리 기능을 사용하겠다고 선언:
	<%@ taglib prefix="" uri="" %> 지시자(directive)를 사용
3) JSTL 기능들:
	core(c), format(fmt), function(fn), xml, sql
--%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JSP</title>
</head>
<body>

<h1>JSTL(Java Standard Tag Library)</h1>
<c:out value="Hello, JSTL!<br/>" />
${'Hello, EL!<br/>' }
Test<br/>

</body>
</html>







