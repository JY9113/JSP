<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>File Upload</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
	.file-drop {
		width : 100%;
		height : 200px;
		border : 1px solid grey;
	}
</style>
</head>
<body>
<h1>Ajax를 이용한 파일 업로드</h1>
<div class="file-drop"></div>
<div class="upload-list"></div>
</body>
<script>
	$(document).ready(function() {		
		// 파일을 끌어다 놓을 때(drag&drop), 브라우저가 파일을 자동으로 열어주는 기능을 막음
		$('.file-drop').on('dragenter dragover', function(event){
			event.preventDefault();	// event의 기본 동작을 막는다.			
		});
		
		$('.file-drop').on('drop', function(event) {
			event.preventDefault();	// event의 기본 동작을 막는다.
			
			// Ajax를 이용해서 서버로 파일을 업로드
			// multipart/form-data 타입으로 파일을 업로드 하기 위해서
			var formData = new FormData();
			
			// drop한 파일들에 대한 정보
			var files = event.originalEvent.dataTransfer.files;
			var i = 0;
			for(i = 0; i < files.length; i++) {
				console.log(files[i]);
				
				// 서버로 보낼 form-data 작성
				formData.append("files", files[i]);
			}
			// jQuery에 있는 ajax함수. 반드시 jQuery 라이브러리가 포함되어 있어야 한다
			// processType에 false를 주지 않으면 form에서 enctype 값이 multipart/form-data가 아니라 기본값이 된다.
			$.ajax({
				type : 'post',
				url : '/ex05/upload-ajax',
				data : formData,
				dataType : 'text',
				processData : false,
				contentType :false,
				/* 
					form의 enctype 속성을 기본값인 "application/x-www-form-urlencoded"을 사용하지 않고, 
					"multipart/form-data"를 사용하기 위해서 processType 속성을 꼭 넣어주어야 한다. 아니면 에러!!
				*/
				success : function(data) {
					alert(data);
					var str = $('.upload-list').html();
					str += '<div>' + '<img src="display?fileName=' + data + '"/>' + data +'</div>';
					$('.upload-list').html(str);
				}
			});
		})
		
		
	});
</script>
</html>