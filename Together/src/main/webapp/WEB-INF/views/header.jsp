<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>team_header</title>
<!-- jquery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--bootstrap-->
<!-- 모바일 디바이스에서  터치, 줌 등을 지원하기 위해서-->
<meta name="viewport" content="width=device-width, initail-scale=1">
<!--Bootstrap 최신 버전의 css 파일들을 링크-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- jQuery 최신 버전의 js 파일들을 링크 -->
<script   src="https://code.jquery.com/jquery-3.2.1.min.js"   integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="  crossorigin="anonymous"></script>
<!-- Bootstrap을  이용하기  위한 최신 버전의 js 파일들을 링크-->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.menu{
	background-color:#5B96D5;
	text-align:right;
	padding: 10px;
}
.head_menu{
color:white;
}
.head_menu:hover{
color : #FFCA9B ;
}
</style>
</head>
<body>
	<div id="logo" style="text-align:center">
		<img alt="logo_com1" src="../resources/images/companey1.png" style="width:200px; height:150px;" id="lc1"/>
	</div><br/><br/>
	<div id="head_menu" class="menu" >
		<a class="head_menu" href="">로그아웃</a>
		<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
		<a class="head_menu" href="">마이페이지</a>
		<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
		<a class="head_menu" href="">설정</a>
		<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
		<a class="head_menu" style="margin-right:10px; href="">홈으로</a>
	</div>
</body>
</html>