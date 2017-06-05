<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

function winPopUpCenter(url, winName, pwidth, pheight, scrollYN, resizeYN){
	var win = null;
	var winL = (screen.width-pwidth)/2;
	var winT = (screen.height-pheight)/2;
	var spec = 'toolbar = no,';
	spec += 'location = no,';
	spec += 'height='+pheight+',';
	spec += 'width='+pwidth;
	var maxW = screen.availWidth;  
	var maxH = screen.availHeight;
	var windowX = (maxW/2)-(pwidth/2);  
	var windowY = (maxH/2)-(pheight/2);
	window.moveTo(windowX,windowY);
	
	win = window.open(url, winName,spec);
	if(parseInt(navigator.appVersion)>=4){
		win.window.focus();
		win.window.moveTo(windowX,windowY);
	}
}

	$(document).ready(function() {
		$('#createChatBtn').click(function() {		
			//height : 1080 height : 1920
			winPopUpCenter('chat_newChat?company_name=woongjin', 'createChat', 650, 800, 'yes', 'no');		
		});
	});

</script>
</head>
<body>
	<div style="margin:5%">
		<article>
			<table class="table">
				<h3>CREATE CHAT</h3>
				<tr>
					<td width=200px  style="border-right: 1px solid #b4b4b4">
						<div id="chat_list">
						<input type="button" id="createChatBtn" value="채팅 시작하기"/>
						</div>
					</td>
					<td>	
						<h3>채팅 목록이 없습니다</h3>     	        	
					</td>
				</tr>
			</table>
		</article>
	</div>	
</body>
</html>