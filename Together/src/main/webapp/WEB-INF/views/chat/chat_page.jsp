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

   var wsocket;
   var chat_count = 0;
   var nickname = '';
   var msg = '';

   function connect() {
      wsocket = new SockJS("http://localhost:8181/together/chat/chat_page");
      wsocket.onopen = onOpen;
      wsocket.onmessage = onMessage;
      wsocket.onclose = onClose;
     
   }

   function disconnect() {
      wsocket.close();
   }
   
   function onOpen(evt) {
      nickname = $("#nickname").val();
      var sendMsg = nickname+"|/|" +"님, 입장하셨습니다"+"<br>";
      wsocket.send(sendMsg);
   }
   
   function onMessage(evt) {
      var data = evt.data;
      if (data.substring(0, 4) == "msg:") {
         data = data.substring(4);
         result = data.split("|/|");      
         var receivedMsg = result[0];
         var receivedNickname = result[1];
         appendMessage(receivedMsg, receivedNickname);
      } else{
         result = data.split("|/|");      
         var receivedMsg = result[1];
          var receivedNickname = result[0];
         $("#chatting").append(receivedNickname+receivedMsg);
         $('#chat_list').append("<br/>" + receivedNickname);
      }
   }
   
   function onClose(evt) {
      nickname = $("#nickname").val();
      $("#chatting").append(nickname + "님, 퇴장하셨습니다"+"<br/>");   
   }
   
   function send() {
      var sendNickname = $("#nickname").val();
      var sendMsg = $("#messageBox").val();   
      wsocket.send("msg:"+ sendMsg + "|/|" + sendNickname);    
      $('#messageBox').val('');
   }
   
   function appendMessage(receivedMsg, receivedNickname) {
      chat_count++;
      
      /* 말풍선 만들기 */
      var chat_li_r = document.createElement("li");
      document.getElementById("chatting").appendChild(chat_li_r);
      if(receivedNickname==nickname){
         chat_li_r.className = "talk_right";
      } else {
         chat_li_r.className = "talk_left";
      }
    
      chat_li_r.id = "li_r" + chat_count;
   
      var chat_a = document.createElement("a");
      document.getElementById("li_r" + chat_count).appendChild(chat_a);
      chat_a.className = "link_cmt";
      chat_a.id = "user" + chat_count;
   
      var user_img = document.createElement("img");
      var firstchar = receivedNickname.substring(0,1);
      document.getElementById("user" + chat_count).appendChild(user_img);
      user_img.className = "thumb_cmt";
      user_img.src = "../resources/images/chat_icon/"+firstchar+".png";
      user_img.style.width = "30px";
      user_img.style.height = "30px";
   
      var user_name = document.createElement("strong");
      document.getElementById("user" + chat_count).appendChild(user_name);
      user_name.className = "tit_writer";
      user_name.style.background = "#f1a9c3"
      user_name.innerText = receivedNickname;
   
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
      chat_content.innerText = receivedMsg;
      
      var maxHeight = $("#chatArea").height();
      var chatHeight = $('#chatting').height(); 
      $("#resultMsg").scrollTop(chatHeight+maxHeight);   
   }

   $(document).ready(function() {
      
      $('#messageBox').keypress(function(event){
      
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
   height : 500px;      
}
</style>
</head>
<body>
   <%@ include file="../header.jsp" %>
   <div style="margin:5%">
      <article>
         <table class="table">
            <h3>채팅 페이지</h3>
            <tr>
               <td width=200px  style="border-right: 1px solid #b4b4b4">
                  <div id="chat_list">
                     <h3>참여멤버</h3>
                  </div>
               </td>
               <td>
               이름:<input type="text" id="nickname">            
                <input type="button" id="enterBtn" value="입장">
                <input type="button" id="exitBtn" value="나가기">
                   <div id="resultMsg" class="chatbox_style">
                     <div id="chatArea"  class="thumb_comm scroll_g"> 
                        <ul class="list_thumb" id="chatting"></ul> 
                     </div>
                  </div>            
                <br/>   
                   <input type="text" id="messageBox">
                   <input type="button" id="sendBtn" value="전송">
               </td>
            </tr>
         </table>
      </article>
   </div>
   <hr/>
   <%@ include file="../footer.jsp" %>
</body>
</html>