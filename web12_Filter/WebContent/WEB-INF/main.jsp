<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Filter</title>
</head>
<body>

<h1>Main Page</h1>
<form action="test-filter" method="post">
	<input type="text" name="username" placeholder="이름"/>
	<input type="submit" value="제출"/>
</form>

<hr/>
이름 : ${username}<br/>

<ul>
	<li><a href="menu1">메뉴 1</a></li>
	<li><a href="menu2">메뉴 2</a></li>
</ul>

</body>
</html>