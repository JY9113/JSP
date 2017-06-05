<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTE-8">
<title>Chat Page</title>
<script type="text/javascript" src="/jquery/jquery-1.11.2.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="/sockjs.min.js"></script>

<script type="text/javascript">

 var wsocket;

 

 function connect() {

  wsocket = new WebSocket(

    "ws://localhost:8181/together/chat/chat_page");

  wsocket.onopen = onOpen;

  wsocket.onmessage = onMessage;


 }

 function disconnect() {
	  wsocket.onclose = onClose;

  wsocket.close();

 }

 function onOpen(evt) {

  appendMessage("연결되었습니다.");

 }

 function onMessage(evt) {

  var data = evt.data;

  if (data.substring(0, 4) == "msg:") {

   appendMessage(data.substring(4));

  }

 }

 function onClose(evt) {

  appendMessage("연결을 끊었습니다.");

 }

 

 function send() {

  var nickname = $("#nickname").val();

  var msg = $("#message").val();

  wsocket.send("msg:"+nickname+":" + msg);

  $("#message").val("");

 }




 function appendMessage(msg) {

  $("#chatMessageArea").append(msg+"<br>");

  var chatAreaHeight = $("#chatArea").height();

  var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;

  $("#chatArea").scrollTop(maxScroll);

 }




 $(document).ready(function() {

  $('#message').keypress(function(event){

   var keycode = (event.keyCode ? event.keyCode : event.which);

   if(keycode == '13'){

    send(); 

   }

   event.stopPropagation();

  });

  $('#sendBtn').click(function() { send(); });

  $('#enterBtn').click(function() { connect(); });

  $('#exitBtn').click(function() { disconnect(); });

 });

</script>


<style>
   table {
      width : 100%;
      height : 800px;      
   }
</style>
</head>
<body>
<%@ include file="../header.jsp" %>
<div style="margin:5%">
   <article>
      <table height="700px" class="table">
         <h3>채팅 페이지</h3>
         <tr>
            <td width=200px style="border-right: 1px solid #b4b4b4">
               <div class="chat_list">
               <h3>참여멤버</h3>
               AAA<br/>
               BBB<br/>
               </div>
            </td>
            <td class="chat_page">
		       이름:<input type="text" id="nickname">

 <input type="button" id="enterBtn" value="입장">

 <input type="button" id="exitBtn" value="나가기">

    

    <h1>대화 영역</h1>

    <div id="chatArea"><div id="chatMessageArea"></div></div>

    <br/>

    <input type="text" id="message">

    <input type="button" id="sendBtn" value="전송">
              <!--  <input type="text" id="chat_id"/>
               <button type="button" id="chat_id_btn">아이디 입력</button>         
               <div id="resultMsg" class="chatbox_style">
                  <div class="thumb_comm scroll_g "> 
                     <ul class="list_thumb" id="chatting"></ul> 
                  </div>
               </div>
               <input type="text" id="input_message"/>
               <button type="button" id="send_message_btn">SEND</button>    -->   
            </td>
         </tr>
      </table>
   </article>
</div>
<%@ include file="../footer.jsp" %>
<script>
   $(document).ready(function() {      
      
      var chat_id ='';
      var chat_count = 0;
      
      $('#chat_id_btn').click(function() {
         chat_id = $('#chat_id').val();      
         $('#chat_id').hide();
         $('#chat_id_btn').hide();
      });      
      
      $('#send_message_btn').click(function() {
         var message = $('#input_message').val();
         chat_count++;
         
            /* 말풍선 만들기 */
            var chat_li_r = document.createElement("li");
            document.getElementById("chatting").appendChild(chat_li_r);
               chat_li_r.className = "talk_right";
            
            chat_li_r.id = "li_r" + chat_count;

            var chat_a = document.createElement("a");
            document.getElementById("li_r" + chat_count).appendChild(chat_a);
            chat_a.className = "link_cmt";
            chat_a.id = "user" + chat_count;

            var user_img = document.createElement("img");
            var firstchar = chat_id.substring(0,1);
            document.getElementById("user" + chat_count).appendChild(user_img);
            user_img.className = "thumb_cmt";
            user_img.src = "../resources/images/chat_icon/"+firstchar+".png";
            user_img.style.width = "30px";
            user_img.style.height = "30px";

            var user_name = document.createElement("strong");
            document.getElementById("user" + chat_count).appendChild(user_name);
            user_name.className = "tit_writer";
            user_name.style.background = "#f1a9c3"
            user_name.innerText = chat_id;

            var chat_p = document.createElement("p");
            document.getElementById("li_r" + chat_count).appendChild(chat_p);
            chat_p.className = "desc_cmt";
            chat_p.id = "chat_bubble" + chat_count;

            /* 말풍선 */
            var chat_a_2 = document.createElement("a");
            document.getElementById("chat_bubble" + chat_count).appendChild(chat_a_2);
            chat_a_2.className = "link_bubble";
            chat_a_2.id = "chat_bubble_box" + chat_count;
                  
            /* 말풍선 꼬리 */
            var bubble_arr = document.createElement("span");
            document.getElementById("chat_bubble_box" + chat_count).appendChild(bubble_arr);
            bubble_arr.className = "ico_arr ico_arright";

            /* 말 */
            var chat_content = document.createElement("span");
            document.getElementById("chat_bubble_box" + chat_count).appendChild(chat_content);
            chat_content.className = "txt_desc";
            chat_content.id = "chat" + chat_count;
            chat_content.innerText = message;
            $('#input_message').val('');
      });
      
      
   });
</script>
</body>
</html>