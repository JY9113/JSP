<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Member</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>회원 정보 수정/삭제 페이지</h1>
<form id="frm">
	<input type="text" name="userid" value="${memberVO.userid }" readonly/><br/>
	<input type="password" name="pwd" value="${memberVO.pwd }" /><br/>
	<input type="email" name="email" value="${memberVO.email }" /><br/>
	<input type="text" name="active" value="${memberVO.active }"/><br/>
</form>
<button type="submit" id="btn_update">수정</button>
<button type="submit" id="btn_delete">삭제</button>

<script>
	$(document).ready(function() {
		var frm = $('#frm');
		
		$('#btn_update').click(function() {
			frm.attr('action','member_update')
			frm.attr('method', 'post');			
			frm.submit();
		});
		
		$('#btn_delete').click(function() {
			frm.attr('action', 'member_delete');
			frm.attr('method','post');			
			frm.submit();
		});
	});
</script>
</body>
</html>