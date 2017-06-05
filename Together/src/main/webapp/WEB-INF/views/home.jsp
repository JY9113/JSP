<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Login Page</title>
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
#m1:hover{
	-webkit-filter:drop-shadow(5px 5px 5px #b4b4b4);
}
#m2:hover{
	-webkit-filter:drop-shadow(5px 5px 5px #b4b4b4);
}
#m3:hover{
	-webkit-filter:drop-shadow(5px 5px 5px #b4b4b4);
}
</style>
</head>
<body style="margin:10%">
	<div id="logo" style="text-align:center">
		<img alt="logo_com1" src="../resources/images/companey1.png" style="width:30%; height:30%;" id="lc1"/>
	</div><br/><br/>
	<div id="menu" style="text-align:center">
		<a href="../team/team_main"><img alt="menu1" style="margin-right:5%; width:200px; height:180px" src="../resources/images/manager.png" id="m1"/></a> 
		<a href="../chat/chat_main"><img alt="menu2" style="margin-right:5%; width:200px; height:180px" src="../resources/images/chat.png" id="m2"/></a>
		<a href=""><img alt="menu3" style="width:200px; height:180px " src="../resources/images/meeting.png" id="m3"/></a>
	</div>
</body>
</html>
