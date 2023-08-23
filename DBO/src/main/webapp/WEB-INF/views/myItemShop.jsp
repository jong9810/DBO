<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DBO 개인 랭킹</title>
<script src="../js/jquery-3.6.4.min.js"></script>
<link href="../css/myItemShop.css" rel="stylesheet" type="text/css" />
<link href="../css/myItemShopmodal.css" rel="stylesheet" type="text/css" />
<link href="../css/cursor.css" rel="stylesheet" type="text/css" />
<script src="../js/loading.js"></script>
<link href="../css/loading.css" rel="stylesheet" type="text/css" />
<link href="../css/itemseffect.css" rel="stylesheet" type="text/css" />
<link href="../css/stars.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/loading.jsp"%>
		<%@ include file="/WEB-INF/views/myItemShopmodal.jsp"%>
		<div id="stars"></div>
        <div id="stars2"></div>
		<header>
			<div id="home">
				<span class="cursorPointer headermenu" onclick="goPage('main')">메인
					화면으로</span>
			</div>
			<div id="title">
				<span>DBO LEAGUE - ItemShop</span>
			</div>
			<div id="id-logout">
				<c:choose>
					<c:when test="${not empty login}">
						<span class="cursorPointer headermenu" onclick="goPage('mypage')">마이페이지</span> | <span
							class="cursorPointer headermenu" onclick="goPage('logout')">로그아웃</span>
					</c:when>
					<c:otherwise>
						<span class="cursorPointer headermenu" onclick="goPage('login')">로그인</span> | <span
							class="cursorPointer headermenu" onclick="goPage('join')">회원가입</span>
					</c:otherwise>
				</c:choose>

			</div>
		</header>
		<main>
			<div id="main-body">
				<section>
					<div>
						<img src="../img/Sprite-0001.png" alt=""
							data-animated="../img/Sprite-0001.gif"
							data-static="../img/Sprite-0001.png" class="cursorPointer arrows"
							onclick="goSpecificPage('${nowpage}')" />
					</div>
					<div class="items">
						<div class="shoptitle">
							<div class="inboxtitle">닉네임 변경 아이템</div>
							<div class="expamount" data-exp="${exp}" id="expamount">${exp} exp. 보유중</div>
						</div>
						<c:choose>
							<c:when test="${empty jumping}">
								<div class="itemblocks cursorPointer openmodal" data-item="jumping" data-price="2000">
									<div class="item cursorPointer jumping openmodal" data-item="jumping" data-price="2000"><span>jumping</span></div>
									<div class="itemname cursorPointer openmodal" data-item="jumping" data-price="2000">콩콩뛰는 닉네임</div>
									<div class="itemexplain cursorPointer openmodal" data-item="jumping" data-price="2000">닉네임을 점프하게 만들어보세요!</div>
									<div class="itemprice cursorPointer openmodal" data-item="jumping" data-price="2000">2000 exp.</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="itemblocks soldout">
									<div class=""><p class="soldout">구매 완료 !!</p></div>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty glowing}">
								<div class="itemblocks cursorPointer openmodal" data-item="glowing" data-price="5000">
									<div class="item cursorPointer glowing openmodal" data-item="glowing" data-price="5000"><span>glowing</span></div>
									<div class="itemname cursorPointer openmodal" data-item="glowing" data-price="5000">빛나는 닉네임</div>
									<div class="itemexplain cursorPointer openmodal" data-item="glowing" data-price="5000">닉네임이 깜박거려요!</div>
									<div class="itemprice cursorPointer openmodal" data-item="glowing" data-price="5000">5000 exp.</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="itemblocks soldout">
									<div class=""><p class="soldout">구매 완료 !!</p></div>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty fire}">
								<div class="itemblocks cursorPointer openmodal" data-item="fire" data-price="7000">
									<div class="item cursorPointer fire openmodal" data-item="fire" data-price="7000"><span>fire</span></div>
									<div class="itemname cursorPointer openmodal" data-item="fire" data-price="7000">불타는 닉네임</div>
									<div class="itemexplain cursorPointer openmodal" data-item="fire" data-price="7000">불이야! 닉네임이 불타게 만들어보세요!</div>
									<div class="itemprice cursorPointer openmodal" data-item="fire" data-price="7000">7000 exp.</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="itemblocks soldout">
									<div class=""><p class="soldout">구매 완료 !!</p></div>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty rainbow}">
								<div class="itemblocks cursorPointer openmodal" data-item="rainbow" data-price="10000">
									<div class="item cursorPointer rainbow openmodal" data-item="rainbow" data-price="10000"><span>rainbow</span></div>
									<div class="itemname cursorPointer openmodal" data-item="rainbow" data-price="10000">그래디언트 무지개색 닉네임</div>
									<div class="itemexplain cursorPointer openmodal" data-item="rainbow" data-price="10000">닉네임을 그래디언트 무지개로 만들어보세요!</div>
									<div class="itemprice cursorPointer openmodal" data-item="rainbow" data-price="10000">10000 exp.</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="itemblocks soldout">
									<div class=""><p class="soldout">구매 완료 !!</p></div>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty retroflicker}">
								<div class="itemblocks cursorPointer openmodal" data-item="retroflicker" data-price="15000">
									<div class="item cursorPointer retroflicker openmodal" data-item="retroflicker" data-price="15000"><span>retro</span></div>
									<div class="itemname cursorPointer openmodal" data-item="retroflicker" data-price="15000">레트로 플리커 효과 닉네임</div>
									<div class="itemexplain cursorPointer openmodal" data-item="retroflicker" data-price="15000">닉네임을 레트로 CRT 감성으로 만들어보세요!</div>
									<div class="itemprice cursorPointer openmodal" data-item="retroflicker" data-price="15000">15000 exp.</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="itemblocks soldout">
									<div class=""><p class="soldout">구매 완료 !!</p></div>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty neon}">
								<div class="itemblocks cursorPointer openmodal" data-item="neon" data-price="15000">
									<div class="item cursorPointer neon openmodal" data-item="neon" data-price="15000"><span>neon</span></div>
									<div class="itemname cursorPointer openmodal" data-item="neon" data-price="15000">네온 무지개색 닉네임</div>
									<div class="itemexplain cursorPointer openmodal" data-item="neon" data-price="15000">닉네임을 네온 무지개로 만들어보세요!</div>
									<div class="itemprice cursorPointer openmodal" data-item="neon" data-price="15000">15000 exp.</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="itemblocks soldout">
									<div class=""><p class="soldout">구매 완료 !!</p></div>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty glitchC}">
								<div class="itemblocks cursorPointer openmodal" data-item="glitchC" data-price="20000">
									<div class="item cursorPointer glitchC openmodal" data-item="glitchC" data-price="20000"><span>glitch</span></div>
									<div class="itemname cursorPointer openmodal" data-item="glitchC" data-price="20000">글리치 효과 닉네임</div>
									<div class="itemexplain cursorPointer openmodal" data-item="glitchC" data-price="20000">닉네임을 고장난 것처럼 만들어보세요!</div>
									<div class="itemprice cursorPointer openmodal" data-item="glitchC" data-price="20000">20000 exp.</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="itemblocks soldout">
									<div class=""><p class="soldout">구매 완료 !!</p></div>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty citynight}">
								<div class="itemblocks cursorPointer openmodal" data-item="citynight" data-price="20000">
									<div class="item cursorPointer citynight openmodal" data-item="citynight" data-price="20000"><span>citynight</span></div>
									<div class="itemname cursorPointer openmodal" data-item="citynight" data-price="20000">저녁 도시 효과 닉네임</div>
									<div class="itemexplain cursorPointer openmodal" data-item="citynight" data-price="20000">닉네임을 세련되고 빛나게 만들어보세요!</div>
									<div class="itemprice cursorPointer openmodal" data-item="citynight" data-price="20000">20000 exp.</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="itemblocks soldout">
									<div class=""><p class="soldout">구매 완료 !!</p></div>
								</div>
							</c:otherwise>
						</c:choose>
						
					</div>
					<div>
						<img src="../img/Sprite-0002.png" alt=""
							data-animated="../img/Sprite-0002.gif"
							data-static="../img/Sprite-0002.png" class="cursorPointer arrows"
							onclick="goSpecificPage('${nowpage}')" />
					</div>
				</section>
			</div>
		</main>
	</div>
</body>
<script src="../js/myItemShop.js"></script>
<script src="../js/myItemShopmodal.js"></script>
</html>
