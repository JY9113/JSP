<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<meta charset="UTE-8">
<title>Ajax</title>
<style>
	div {
		width : 400px;
		height : 200px;
		margin : 10px;
		border : 1px solid pink;
	}
</style>
</head>
<body>
<h1>Ajax : Asynchronous JavaScript And XML</h1>
<h2>자바스크립트를 사용한 비동기 통신 방식</h2>
<button id="btn">클릭</button>
<div id="result">
</div>
<div id="log">
</div>

<script>
	$(document).ready(function() {
		/*
			Ajax 사용 순서
			1. 클라이언트(브라우저)
				1) XMLHttpRequest 객체 생성 -> 서버로 전송
				2) 서버에서 처리된 response를 처리할 수 있는 함수를 등록
			2. 서버
				1) XMlHttpRequest를 처리 -> HttpResponse 객체 생성
				2) 응답(response)를 클라이언트로 전송
			3. 클라이언트(브라우저)
				1) 서버에서 전송된 데이터를 등록한 점수를 통해서 처리
				2) 화면(페이지) 업데이트
		*/
		
		$('#btn').click(function() {		
			// XMLHttpRequest 객체 생성
			var xhr = new XMLHttpRequest();
			// 요청 open(get/post, 서버 리소스 주소, Async 방식(async=true, async != false))
			xhr.open('GET', 'test.txt', true);
			// 요청 전송
			xhr.send();
			
			// 서버에서 이벤트/응답이 왔을 때 처리할 이벤트 핸들러 함수 등록
			xhr.onreadystatechange = function() {
				var readyState = xhr.readyState;
				var log = $('#log');
				var msg = log.html();
				
				if (readyState ===0){
					msg += '요청 초기화 이전<br/>';
				} else if(readyState === 1){
					msg += '서버와 연결됨<br/>';
				} else if(readyState === 2) {
					msg += '서버가 요청을 받음<br/>';
				} else if(readyState === 3) {
					msg += '서버에서 요청 처리중<br/>';
				} else if(readyState === 4) {
					msg += '요청 처리 끝/ 응답 사용 가능<br/>';
				}
				log.html(msg);
				
				var result = $('#result');
				if(readyState === 4 && xhr.status === 200) {
					result.html(xhr.responseText);				
				}
			};
		});
		
	});
</script>
</body>
</html>