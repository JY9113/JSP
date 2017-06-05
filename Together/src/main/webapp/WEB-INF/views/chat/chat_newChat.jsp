<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Chat Page</title>
<link href="../resources/css/style.css" media="all" rel="stylesheet" type="text/css" />
<link href="../resources/css/style2.css" media="all" rel="stylesheet" type="text/css" />
<link href="../resources/css/style3.css" media="all" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../resources/jquery/jquery-1.11.2.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/sockjs.min.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		var select_team = document.getElementById('#chat_team_select');		
		$('#chat_team_select').change(function() {
			var team_val = this.options[this.selectedIndex].value;
			var vo = "<c:out value="${teamList}" />";
// 			var team_member = '${teamList}';
			var result = ${vo.team_member};
			$('#selected_member').append(result).append("<br/>");	
		});

	});

</script>
</head>
<body>
	<div style="margin:5%">
		<article>
				<form action="" method="GET">
				<div class="select_member">
					<h3>채팅 멤버 선택</h3>
					<select id="chat_team_select">
						<c:forEach var="vo" items="${teamList}">
							<option value="${vo.team_name }">${vo.team_name }</option>
						</c:forEach>
					</select>
					</div>
				</form>
				
				<form action="" method="POST">
				<table class="display_member">
				</table>
				<hr/>
				<div class="selected_member" id="selected_member">
				</div>
				</form>
		</article>
	</div>	

</body>
</html>