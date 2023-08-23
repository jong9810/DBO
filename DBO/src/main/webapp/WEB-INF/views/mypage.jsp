<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>DBO 마이페이지</title>
    <script src="/js/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/cursor.css" />
    <link rel="stylesheet" href="/css/mypage.css" />
    <link rel="stylesheet" href="/css/stars.css" />
    <script src="../js/loading.js"></script>
		<link href="../css/loading.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <div class="wrapper">
    	<%@ include file="/WEB-INF/views/loading.jsp" %>
    	<div id="stars"></div>
      <div id="stars2"></div>
      <header>
        <div id="home">
        	<span class="font-S cursorPointer">메인 화면으로</span>
        </div>
        <div id="title">
          <span class="font-XL">DBO LEAGUE - My Page</span>
        </div>
        <div id="id-logout">
          <span id="mypage-btn" class="font-S cursorPointer">마이페이지</span> | 
          <span id="logout-btn" class="font-S cursorPointer">로그아웃</span>
        </div>
      </header>
      <main>
        <div id="main-header">
          <div id="user-info" class="font-M">
            <ul>
              <li>
	              Lv${member_lv}. 
	              <div style="display: inline;">
	              	<span>${memberDto.member_nick}</span>
	             	</div>
             	</li>
              <li>소속팀 : ${memberDto.member_team}</li>
              <li>이메일 : ${memberDto.member_email}</li>
              <li style="display: flex; align-items: center">
              	<span>EXP : </span>
              	<div class="progress" style="width: 200px; margin: 0 10px;">
								  <div class="progress-bar bg-success" role="progressbar" style="width: ${exp_percent}%;" aria-valuenow="${exp_percent}" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
            		<span>${exp_percent} / 100(%)</span>
              </li>
            </ul>
          </div>
          <div id="top-btns">
          	<table>
          		<tbody>
          			<tr>
          				<td>
          					<button id="change-nick-btn" class="font-M cursorPointer btns">닉네임 변경</button>
          				</td>
          				<td>
          					<button id="change-pw-btn" class="font-M cursorPointer btns">비밀번호 변경</button>
          				</td>
          			</tr>
          			<tr>
          				<td>
          					<button id="decorate-store" class="font-M cursorPointer btns">꾸미기 아이템</button>
          				</td>
          				<td>
          					<button id="delete-member-btn" class="font-M cursorPointer btns">회원탈퇴</button>
          				</td>
          			</tr>
          		</tbody>
          	</table>
          </div>
        </div>
        <div id="main-body">
          <section>
          	<div id="play-stat">
          		<div>
              	<p class="font-L">플레이 통계</p>
              </div>
              <div>
		            <table class="font-M">
		            	<tbody>
		            		<tr>
		            			<td>플레이한 게임 수</td>
		            			<td>성공 횟수</td>
		            		</tr>
		            		<tr>
		            			<td>${memberDto.member_total}회</td>
		            			<td>${memberDto.member_win}회</td>
		            		</tr>
		            		<tr>
		            			<td>총 획득한 경험치</td>
		            			<td>승률</td>
		            		</tr>
		            		<tr>
		            			<td>${memberDto.member_allexp}exp</td>
		            			<td>
		            				${memberDto.member_total != 0 
		            				? win_rate
		            				: 0.0}%
		            			</td>
		            		</tr>
		            	</tbody>
		            </table>
	            </div>
           	</div>
          </section>
          <section>
            <div id="latest-result">
            	<div>
              	<p class="font-L">최근 전적</p>
              </div>
              <div>
	              <table class="font-S">
	                <tbody>
	                  <tr class="font-M" style="height: 45px;">
	                    <td>결과</td>
	                    <td>총회차</td>
	                    <td>도전 날짜</td>
	                    <td>상세전적</td>
	                  </tr>
	                  <c:if test="${!empty singleRecords}">
		                	<c:forEach items="${singleRecords}" var="record" varStatus="vs">
		                		<tr>
	               					<td>${record.single_result}</td>
	                				<td>${record.single_all}회</td>
	                				<td>${fn:split(record.exp_date, ".")[0]}</td>
	                				<td id="${vs.index}" class="btns" style="border-radius: 0px">보기</td>
                				</tr>
		                	</c:forEach>
	                	</c:if>
	                </tbody>
	              </table>
              </div>
            </div>
          </section>
        </div>
      </main>
    </div>
    <div id="record-detail-wrapper" style="display: none">
	    <div id="record-detail">
	    	<p style="margin: 0px; padding: 3px 3px 3px 10px;">전적 상세내용</p>
	    	<p style="margin: 0px; padding: 3px 3px 3px 10px;"></p>
	    	<table>
	    		<tbody></tbody>
	    	</table>
	    </div>
	  </div>
  </body>
  <script src="/js/mypage.js"></script>
</html>
