<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 폼</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<style>
	@font-face {
		font-family: 'NeoDGM';
		src: url('/fonts/neodgm.woff') format('woff');
		font-weight: normal;
		font-style: normal;
	}
	* {
	  margin: 0px;
	  padding: 0px;
	  box-sizing: border-box;
	  font-family: 'NeoDGM';
	}
	html, body {
		height: 100%;
		margin: 0px;
		padding: 0px;
		background-color: black;
		color: white;
	}
	html {
		overflow-x:hidden; 
		overflow-y:hidden;
	}
	header {
		padding-left: 30px;
		height: 60px;
		line-height: 60px;
		background-color: #B9B9B9;
		color: black;
		margin-bottom: 20px;
		font-size: 19px;
	}
	main {
		width: 100%;
		height: 100%;
		display: flex;
		align-items: center;
	}
	#form {
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	#form > div, li {
		margin-bottom: 7px;
	}
	ul {
		list-style: none;
	}
	#form, button {
		font-size: 17px;
	}
	button {
		width: 50px;
		height: 30px;
	}
	.btns {
	  background: #c1ec42;
	  border: 0px;
	  position: relative;
	  box-shadow: 
	    inset -2px 2px 1px 1px #d5ee99,
	    inset -2px -2px 1px 1px #537726,
	    inset 2px 0px 1px 1px #7abc69
	}
	.btns:active {
	  top: 2px;
	}
	.btns::after {
	  content: '';
	  background: #000;
	  position: absolute;
	  left: -2%;
	  top: 0;
	  width: 104%;
	  height: 100%;
	  z-index: -1
	}
	.btns::before {
	  content: '';
	  background: #000;
	  position: absolute;
	  left: 0;
	  top: -5%;
	  width: 100%;
	  height: 110%;
	  z-index: -2
	}
	.btns:focus {
		border: none;
		outline: none;
	}
	input:focus {
		outline: none;
		height: 17px;
	}
</style>
</head>
<body>
<header>비밀번호 변경</header>
<main>
	<div id="form">
		<div>
			<ul>
				<li>
					<span>현재 비밀번호 &nbsp;&nbsp; : </span>
					<input id="curPw" type="password" />
				</li>
				<li>
					<span>새 비밀번호 &nbsp;&nbsp;&nbsp;&nbsp; : </span>
					<input id="newPw1" type="password" />
				</li>
				<li>
					<span>새 비밀번호 확인 : </span>
					<input id="newPw2" type="password" />
				</li>
			</ul>
		</div>
		<div>
			<button id="change" class="btns">변경</button>
			<button id="cancel" class="btns">취소</button>
		</div>
	</div>
</main>
<script src="js/changePw.js"></script>
</body>
</html>