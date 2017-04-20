<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>JSP</title>
</head>
<body>

<h1>여러가지 Form 양식</h1>
<form action="08_result.jsp" method="get">
	<input type="text" name="user_name" placeholder="이름"
		required autofocus/>
	<br/>
	<input type="number" name="user_age" placeholder="나이" />
	<br/>
	<input type="radio" name="mail_receive" value="accept"
		id="mail_accept" checked />
	<label for="mail_accept">수신 동의</label>
	<input type="radio" name="mail_receive" value="deny"
		id="mail_deny" />
	<label for="mail_deny">수신 거부</label>
	<br/>
	<input type="checkbox" name="hobby" value="movie"
		id="ch_movie" />
	<label for="ch_movie">영화</label>
	<input type="checkbox" name="hobby" value="music"
		id="ch_musics"/>
	<label for="ch_music">음악</label>
	<input type="checkbox" name="hobby" value="code"
		id="ch_code"/>
	<label for="ch_code">코딩</label>
	<input type="checkbox" name="hobby" value="sports"
		id="ch_sports"/>
	<label for="ch_sports">스포츠</label>
	<br/>
	<select name="email">
		<option value="none" selected disabled>--선택--</option>
		<option value="@naver.com">네이버</option>
		<option value="@daum.net">다음</option>
		<option value="@gmail.com">구글</option>
	</select>
	<br/>
	<input type="submit" value="제출"/>
	<input type="reset" value="취소"/>
</form>

</body>
</html>