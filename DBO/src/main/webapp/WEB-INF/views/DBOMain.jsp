<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>게임 메인 화면</title>
<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/loading.js"></script>
<link rel="stylesheet" href="/css/common.css" />
<link rel="stylesheet" href="/css/main.css" />
<link href="../css/loading.css" rel="stylesheet" type="text/css" />
<link href="../css/cursor.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class=wrapper>
<%@ include file="/WEB-INF/views/loading.jsp" %>
  <header>
    <div class="header-content">
		<c:choose>
		    <c:when test="${not empty loginNick}">
		        <div class="user-info font-M">
		             환영합니다, ${loginNick}님. / <a href="mypage" class="cursorPointer"> 마이페이지 </a> &nbsp;/ <a href="/mainlogout" class="cursorPointer"> 로그아웃 </a>
		        </div>
		    </c:when>
		    <c:otherwise>
		        <div class="user-info font-M">
		            <a href="/login" class="cursorPointer">로그인</a> &nbsp;/ <a href="/join" class="cursorPointer">회원가입</a>
		        </div>
		    </c:otherwise>
		</c:choose>
    </div>

  </header>
  
 	<main>
	    <div class="main-background">
	    
	    	<div id="modal" class="modal">
	    		<div class="close-modal">
			      	<img src="/img/xbutton.png" class="cursorPointer">
			    </div>
			    <div class="modal-content">
				    <div class="rankgamebtn">
				        <div class="rankimage">
				            <a href="/game?mode=rank" class="cursorPointer" id="rankLinkImage">
				                <img src="/img/modal-button.png/" class="cursorPointer">
				            </a>
				        </div>
				        
				        <div class="ranktext cursorPointer" >
				            <a href="/game?mode=rank" class="cursorPointer" id="rankLinkText">
				                랭킹게임
				            </a>
				        </div>
				    </div>
			    	<div class="normalgamebtn">
			    		<a href = "/game">
				    		<div class="normalimage">
								<img src="/img/modal-button.png/" class="cursorPointer">
							</div>
							<div class="normaltext cursorPointer">일반게임</div>
						</a>
					</div>
			    </div>
	  		</div>

	    	<div id="modal2" class="modal2">
	    		<div class="close-modal2">
			      	<img src="/img/xbutton.png" class="cursorPointer">
			    </div>
			    <div class="modal2-content">
					<div class="howtotitle">게임설명</div>
					<div class="howtotext">DBO League는 임의로 주어진 4자리 숫자의 각각의 수와 위치를 모두 맞추는 게임입니다.
					<br><br>이닝 당 한번 씩 4자리 수를 입력하여 주어진 수와 비교하여 다음과 같은 결과를 얻을 수 있습니다.<br><br>
					&nbsp;&nbsp;&nbsp;- 볼 : 숫자는 맞지만 위치가 틀렸습니다.<br>
					&nbsp;&nbsp;&nbsp;- 스트라이크 : 숫자와 위치가 모두 일치합니다.<br>
					&nbsp;&nbsp;&nbsp;- 아웃 : 숫자와 위치 모두 틀렸습니다.
					<br><br>한 게임 당 총 9이닝을 진행하며, 그 안에 주어진 숫자를 유추하면 당신의 승리입니다!</div>
			    </div>
	  		</div>
	  			  			  		
	      <div class="thelogo">
		      <div class="logoimg"><img src="/img/dbologo3.png"></div>
		      <div class="logo">DBO League</div>
	      </div>
	      <div class="buttons">
	        <div class="main-button start">
	        	<img src="/img/startbtn.png" alt="Start Button" id="startButton" class="cursorPointer">
	        </div>
	        <div class="main-button readme">
	        	<img src="/img/howtobtn.png" alt="Howto Button" id="howtoButton" class="cursorPointer">
			</div>
	        <div class="main-button ranking">
	        	<a href="/ranking">
	        	<img src="/img/rankingbtn.png" alt="Ranking Button" id="rankingButton" class="cursorPointer">
	        	</a>
	        </div>
	      </div>
	    </div>
	    
	</main>
  
	</div>
	<script>
	    const gameButton = document.querySelector('.main-button.start');
	    const modal = document.getElementById('modal');
	    const closeModalButtons = document.querySelectorAll('.close-modal img');
	    const loginNick = "${loginNick}".trim();
	    
	    gameButton.addEventListener('click', () => {
	        modal.style.display = 'block';
	    });
	
	    closeModalButtons.forEach(button => {
	        button.addEventListener('click', () => {
	            modal.style.display = 'none';
	        });
	    });
	
	    const howtoButton = document.querySelector('.main-button.readme');
	    const modal2 = document.getElementById('modal2');
	    const closeModal2Buttons = document.querySelectorAll('.close-modal2 img');
	
	    howtoButton.addEventListener('click', () => {
	        modal2.style.display = 'block';
	    });
	
	    closeModal2Buttons.forEach(button => {
	        button.addEventListener('click', () => {
	            modal2.style.display = 'none';
	        });
	    });
	
	    const buttons = [
	        { element: document.getElementById('rankingButton'), selectedImageSrc: '/img/rankingbtnselected.png', originalImageSrc: '/img/rankingbtn.png' },
	        { element: document.getElementById('howtoButton'), selectedImageSrc: '/img/howtobtnselected.png', originalImageSrc: '/img/howtobtn.png' },
	        { element: document.getElementById('startButton'), selectedImageSrc: '/img/startbtnselected.png', originalImageSrc: '/img/startbtn.png' }
	    ];
	
	    buttons.forEach(button => {
	        let isButtonClicked = false;
	
	        button.element.addEventListener('mousedown', () => {
	            button.element.src = button.selectedImageSrc;
	            isButtonClicked = true;
	        });
	
	        window.addEventListener('mouseup', () => {
	            if (isButtonClicked) {
	                button.element.src = button.originalImageSrc;
	                isButtonClicked = false;
	            }
	        });
	
	        window.addEventListener('mouseout', () => {
	            if (isButtonClicked) {
	                button.element.src = button.originalImageSrc;
	                isButtonClicked = false;
	            }
	        });
	    });
	
	    const rankLinkImage = document.getElementById('rankLinkImage');
	    const rankLinkText = document.getElementById('rankLinkText');
	
	    rankLinkImage.addEventListener('click', (event) => {
	        if (loginNick === "") {
	            event.preventDefault(); // 링크 동작을 취소
	            alert('로그인 후에 이용하실 수 있습니다.');
	        }
	    });
	
	    rankLinkText.addEventListener('click', (event) => {
	        if (loginNick === "") {
	            event.preventDefault(); // 링크 동작을 취소
	            alert('로그인 후에 이용하실 수 있습니다.');
	        }
	    });
	</script>
</body>
</html>