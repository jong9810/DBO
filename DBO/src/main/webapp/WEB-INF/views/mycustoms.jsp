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
<link href="../css/mycustomsmodal.css" rel="stylesheet" type="text/css" />
<link href="../css/cursor.css" rel="stylesheet" type="text/css" />
<script src="../js/loading.js"></script>
<link href="../css/loading.css" rel="stylesheet" type="text/css" />
<link href="../css/itemseffect.css" rel="stylesheet" type="text/css" />
<link href="../css/stars.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/loading.jsp"%>
		<%@ include file="/WEB-INF/views/mycustomsmodal.jsp"%>
		<div id="stars"></div>
		<div id="stars2"></div>
		<header>
			<div id="home">
				<span class="cursorPointer headermenu" onclick="goPage('main')">메인
					화면으로</span>
			</div>
			<div id="title">
				<span>DBO LEAGUE - My Custom Items</span>
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
							<div class="inboxtitle">내 커스터마이징 아이템</div>
							<div class="expamount" data-exp="${exp}" id="expamount">${exp}
								exp. 보유중</div>
						</div>
						<c:choose>
							<c:when test="${nicknameon eq 'none'}">
								<div class="itemblocks cursorPointer openmodal"
									data-item="nickname">
									<div class="item cursorPointer openmodal" data-item="nickname">
										<span>닉네임</span>
									</div>
									<div class="itemname cursorPointer openmodal"
										data-item="nickname">
										<span>아무런 아이템도 적용중이 아닙니다...</span>
									</div>
									<div class="itemexplain cursorPointer openmodal"
										data-item="nickname">클릭해서 적용중인 아이템을 변경해보세요!</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="itemblocks cursorPointer openmodal"
									data-item="nickname">
									<div class="item cursorPointer openmodal" data-item="nickname">
										<span>닉네임</span>
									</div>
									<div class="itemname cursorPointer openmodal ${nicknameon}"
										data-item="nickname">
										<span>${nicknameon} 아이템 적용중</span>
									</div>
									<div class="itemexplain cursorPointer openmodal"
										data-item="nickname">클릭해서 적용중인 아이템을 변경해보세요!</div>
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
<script src="../js/mycustomsmodal.js"></script>
</html>
