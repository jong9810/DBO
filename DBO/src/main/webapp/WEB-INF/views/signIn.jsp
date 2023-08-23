<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/signIn.css">
<link href="../css/cursor.css" rel="stylesheet" type="text/css" />
<link href="../css/stars.css" rel="stylesheet" type="text/css" />
</head>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/signIn.js"></script>
<body>
	<div class="wrapper">
		<div id="stars"></div>
		<div id="stars2"></div>
		<div class="logo">
			<a href="/main" class="cursorPointer">DBO League</a>
		</div>
		<form id="login_form" action="/login" method="post">
			<div class="login">
			
				<div class='cursorPointer formindiv'>
					<p>아이디</p>
						<input id="member_id" name="member_id" type="text" class="cursorPointer" autocomplete='off' maxlength="16">
				</div>

				<div class='cursorPointer formindiv'>
					<p>비밀번호</p>
					<label><input id="member_pw" name="member_pw"
						autocomplete="off" type="password" maxlength="16" class="cursorPointer"></label>
				</div>
				<div class="cursorPointer checkbox">
					<div class="cursorPointer id-pw-td">
								<div class="cursorPointer id-save">
									<input id="member_check_save_id0" name="check_save_id" value="T" type="checkbox" class="cursorPointer">
                                     <label for="member_check_save_id0" style="color:white" class="cursorPointer">아이디 저장</label>
								</div>
								</div>
						</div>
				<div class='cursorPointer formindiv'>
					<h5>${loginfail}</h5>
					<div id="Error" class="error"></div>
					<button type="button" id="login_submit_btn" class="cursorPointer">로그인</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>