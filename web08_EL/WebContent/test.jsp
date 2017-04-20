<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Test</title>
<style>
 body {
 	border : 1px solid grey;
 	width : 300px;
 	align : center;
 }
</style>
</head>
<body>
<form action="testResult" method="get">
<input type="text" name="userid" placeholder="아이디 입력" required/><br/>
<input type="password" name="userpw" placeholder="비밀번호 입력"/><br/>
<input type="password" name="userpw2" placeholder="비밀번호 확인"/><br/>
<input type="text" name="name" placeholder="이름"/><br/>
<input type="radio" name="gender" value="남자"/>
<label value="남자">남자</label>
<input type="radio" name="gender" value="여자"/>
<label value="여자">여자</label><br/>
<input type="submit" name="submit"/>
</form>	
</body>
</html>