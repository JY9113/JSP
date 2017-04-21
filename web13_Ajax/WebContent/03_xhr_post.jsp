<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<meta charset="UTE-8">
<title>Insert title here</title>
</head>
<body>
<h1>XMLHttpRequest POST 방식 요청</h1>
<input type="text" placeholder="ID" id="userid"/>
<input type="password" placeholder="PW" id="userpw"/>
<button type="bytton" id="btn">Ajax Post 요청</button>
<div id="result"></div>

<script>
$(function() {
		$('#btn').click(function(){
			var id = $('#userid').val();
			var pw = $('#userpw').val();
			
			var xhr = new XMLHttpRequest();
			xhr.open('POST', 'ajax_test.jsp', true);	// true = async 방식 쓰겠다
			// POST 방식에서는 요청 헤더 정보 설정이 필요
			xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			// POST 방식으로 보낼 데이터 설정
			var data = "id=" + id + "&pw=" + pw;
			// send(data) 메시지 호출 - 요청 전송
			xhr.send(data);
			
			// 응담처리를 할 수 있는 핸들러 함수 등록
			xhr.onreadystatechange = function() {
				if(xhr.readyState === 4 && xhr.status === 200) {
					$('#result').html(xhr.responseText);
				}
			};
			
		});
});
</script>
</body>
</html>