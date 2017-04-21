<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<meta charset="UTE-8">
<title>Ajax</title>
</head>
<body>
<h1>XMLHttpRequest GET</h1>

<input type="text" placeholder="아이디 입력하세요" id="userid"/>
<input type="password" placeholder="비밀번호" id="userpw"/>
<button type="button" id="btn">Ajax 전송</button>
<div id="result">
	<script>
		$(document).ready(function(){
			$('#btn').click(function() {
				var id = $('#userid').val();
				var pw = $('#userpw').val();
				//ajax_test.jsp?id=admin'&pw=1234
				var url = 'ajax_test.jsp?id=' + id + '&pw=' + pw;
				var xhr = new XMLHttpRequest();
				xhr.open('GET', url, true);
				xhr.send();
				xhr.onreadystatechange = function() {
					if(xhr.status == 404) {
						console.log('페이지 못 찾았어요');
					}
					if(xhr.readyState == 4 && xhr.status == 200) {
						$('#result').html(xhr.responseText);
					}
				};
			});
		});
	</script>
</div>
</body>
</html>