<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/signUp.css">
<link href="../css/cursor.css" rel="stylesheet" type="text/css" />
<link href="../css/stars.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../css/pixel-alert.css">
</head>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/signUp.js"></script>
<body>
	<div class="wrapper">
		<div id="stars"></div>
		<div id="stars2"></div>
		<div id="loginAlert" class="hidden">
			<img src="/img/face-happy.svg" style="width: 30px; height: 30px;">
			<p></p>
		</div>
		<div id="pixelAlert" class="hidden">
			<img src="/img/face-angry.svg" style="width: 30px; height: 30px;">
			<p></p>
			<button id="customAlertButton" class="cursorPointer close-button">
				<img src="/img/times.svg" style="width: 20px; height: 20px;">
			</button>
		</div>
		<div class="logo">
			<a href="/main" class="cursorPointer">DBO League</a>
		</div>
		<form id="join_form" action="/join" method="post">
			<div class="join">
				<div class='cursorPointer formindiv'>
					<p>아이디</p>
					<div id=id_div>
						<input id="member_id" name="member_id" type="text" class="cursorPointer" autocomplete='off' maxlength="16">
						<a class="help">(영문 대소문자/숫자로 조합, 6자~16자)</a>
						<div id="idError" class="error"></div>
					</div>
				</div>

				<div class='cursorPointer formindiv'>
					<p>비밀번호</p>
					<label><input id="member_pw" name="member_pw"
						autocomplete="off" type="password" maxlength="16" class="cursorPointer"></label>
						<a class="help">(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자)</a>
						<div id="pwError" class="error"></div>
				</div>

				<div class='cursorPointer formindiv'>
					<p>비밀번호 확인</p>
					<label><input type="password" name="memPw_confirm"
						id="memPw_confirm" value="" autocomplete="off" maxlength="16" class="cursorPointer"></label>
						<div id="pwConfirmError" class="error"></div>
				</div>

				<div class='cursorPointer formindiv'>
					<p>닉네임</p>
					<input id="member_nick" name="member_nick" type="text" maxlength="20" class="cursorPointer" autocomplete='off'>
					<div id="nickError" class="error"></div>
				</div>

				<div class='cursorPointer formindiv'>
					<p>E-mail</p>
					<input id="member_email" name="member_email" type="text" maxlength="80" class="cursorPointer" autocomplete='off'>
				<div id="emailError" class="error"></div>
				<div id="ineError" class="error"></div>
				</div>
			</div>
			
			<div id="join_btn" class='cursorPointer formindiv'>
				<button type="button" class="cursorPointer join_submit_btn" id="join_submit_btn">회원가입</button>
			</div>
			
		</form>
	</div>
</body>
</html>