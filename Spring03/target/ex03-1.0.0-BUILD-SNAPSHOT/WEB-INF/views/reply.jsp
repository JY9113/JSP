<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Reply</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<h1>댓글 페이지</h1>
<div>
	<input type="text" id="rtext" placeholder="댓글을 입력하세요" />
	<input type="text" id="replier" placeholder="아이디" />
	<button type="button" id="btn_add">작성</button>
</div>

<hr/>
<div id="replies">
</div>

<script>
$(document).ready(function() {
	var bno = 1;
	
	getAllReplies();
	
	function getAllReplies() {
		// $.get(url, callback함수), ajax 요청
		// $.getJSON(url, data, callback함수)
		//		url : 서버의 요청 주소 (urlMapping)
		//		data : 요청과 함께 보낼 데이터, 데이터가 없으면 안보내도 된다.
		//		callback : JSON 데이터가 리턴됐을때 처리 할 함수
		var url = '/ex03/replies/all/' + bno;
		$.getJSON(url, function(jsonData) {
			console.log(jsonData.length);
			var list = '';
			var i;
			/* for (i = 0; i < jsonData.length; i++) {} */
			$(jsonData).each(function() {
				// array 의 첫번째 원소가 func 호출, 두번째가 func 호출.....
				var date = new Date(this.regdate);
				//this 는 function을 호출 한 주체.(첫번째, 두번째 jsonData)
				var dateString = date.toLocaleDateString();
				//console.log(dateString);
				list += '<div class="reply_item">'
					+ '<input type="hidden" id="rno" value="'
					+ this.rno
					+ '" /><br/>'
					+ '<input type="text" id="rtext" value="'
					+ this.rtext
					+ '" /><br/>'
					+'<input type="text" id="replier" value="'
					+ this.replier
					+ '" readonly /><br/>'
					+ dateString + '<br/>'
					+ '<button class="btn_update" type="button">수정</button>'
					+ '<button class="btn_delete" type="button">삭제</button>'
					+ '</div><hr/>';
			}); // end each()
			$('#replies').html(list);
		});
	} // end getAllReplies()
	
	$('#btn_add').click(function() {
		var rtext = $('#rtext').val();
		var replier = $('#replier').val();
		// Ajax 요청을 보냄
		$.ajax({
			type: 'post',
			url: '/ex03/replies',
			headers: {
				'Content-Type': 'application/json',
				'X-HTTP-Method-Override': 'POST'
			},
			data: JSON.stringify({
				// rno 는 url 에 포함되어 있으므로 data 값으로 넘기지 않아도 된다.
				'bno': bno,
				'rtext': rtext,
				'replier': replier
			}),
			success: function(result) {
				if (result === 1) {
					alert('댓글 입력 성공');
					$('#rtext').val('');
					$('#replier').val('');
					getAllReplies();
				}
			}
		});
		
	}); // 댓글 입력 처리
	
	$('#replies').on('click', 
			'.reply_item .btn_update',
			function() {
		// 해당 버튼의 rno, rtext 값을 읽음
		var rno = $(this).prevAll('#rno').val();
		var rtext = $(this).prevAll('#rtext').val();
		// Ajax 요청
		$.ajax({
			type: 'put',
			url: '/ex03/replies/' + rno,
			headers: {
				'Content-Type': 'application/json',
				'X-HTTP-Method-Override': 'PUT'
			},
			data: JSON.stringify({
				'rtext': rtext
			}),
			success: function(result) {
				if (result === 'success') {
					alert(rno + '번 댓글 수정 성공');
					getAllReplies();
				}
			}
		});
	}); // 댓글 수정 처리
	
	$('#replies').on('click', 
			'.reply_item .btn_delete', 
			function() {
		var rno = $(this).prevAll('#rno').val();
		var ret = confirm('정말 삭제하시겠습니까?');
		if(ret === true) {
			$.ajax({
				type: 'delete',
				url: '/ex03/replies/' + rno,
				headers: {
					'Content-Type': 'application/json',
					'X-HTTP-Method-Override': 'DELETE'
				},
				success: function(result) {
					if (result === 'success') {
						alert(rno + '번 댓글 삭제 성공');
						getAllReplies();
					}
				}
			});
		}
		
	}); // 댓글 삭제 처리
});
</script>

</body>
</html>






