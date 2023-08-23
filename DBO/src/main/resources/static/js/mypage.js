/**
 * 마이페이지 js
 */

// 메일 화면으로 클릭
$("#home").click(function() {
	location.href = "/main";
}); //click

// 마이페이지 클릭
$("#logout-btn").click(function() {
	location.href = "/mypage";
}); //click
// 로그아웃 클릭
$("#logout-btn").click(function() {
	location.href = "/logout";
}); //click

// 닉네임 변경 버튼 클릭
$("#change-nick-btn").click(function() {
	window.open("/changeNick", "", "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=400, height=250, top=0,left=0");
}); //click

// 비밀번호 변경 버튼 클릭
$("#change-pw-btn").click(function() {
	window.open("/changePw", "", "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=400, height=300, top=0,left=0");
}); //click

// 꾸미기 아이템 버튼 클릭
$("#decorate-store").click(function() {
	 location.href = "/mycustoms";
}); //click

// 회원 탈퇴 버튼 클릭
$("#delete-member-btn").click(function() {
	let isDelete = confirm("회원의 모든 정보가 삭제됩니다. 그래도 탈퇴하시겠습니까?");
	if (isDelete) {
		$.ajax({
			url: "/deleteMember",
			dataType: "json",
			method: "post",
			success: function(response) {
				if (response.deleteResult === -1) alert("세션이 만료되어 로그아웃 되었습니다.");
				else if (response.deleteResult === 1) {
					alert("정상적으로 탈퇴 처리되었습니다.");
					location.href = "/main";
				} else alert("알 수 없는 이유로 탈퇴가 처리되지 않았습니다.");
			},
			error: function(request,error) {
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
		}); //ajax
	} //if
}); //click

// 상세전적 보기 버튼 클릭시
$("#latest-result td.btns").click(function() {
	let recordIdx = this.id;
	$("#record-detail-wrapper").css("display", "inline");
	$.ajax({
			url: "/showRecordDetail",
			data: {
				"detailIdx": recordIdx,
			},
			dataType: "json",
			method: "post",
			success: function(response) {
				if (response.ajaxResult === -1) {
					alert("세션이 만료되어 로그아웃 되었습니다.");
					location.href = "/main";
				} else if (response.ajaxResult === 1) {
					// 게임 정답을 html에 보여줌
					$("#record-detail > p").eq(1).text(`정답 : ${response.singleRecords[recordIdx].single_answer}`);
					$("#record-detail tbody").html(`
						<tr>
							<td style="width: 20%;">회차</td>
		    			<td style="width: 50%;">도전한 수</td>
		    			<td style="width: 30%;">결과</td>
						</tr>
					`);
					for (let i = 0; i < response.singleDetails.length; i++) {
						// 게임 회차별 결과를 html에 보여줌
						$("#record-detail tbody").append(`<tr></tr>`);
						$("#record-detail tbody tr").eq(i + 1).append(`
							<td>${response.singleDetails[i].innings_count}</td>
							<td>${response.singleDetails[i].innings_chall}</td>
							<td>
								<span style="color: yellow">${response.singleDetails[i].innings_strike}S <span>
								<span style="color: green">${response.singleDetails[i].innings_ball}B <span>
							</td>
						`);
					} //for
				} //else
			}, //success
			error: function(request,error) {
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
		}); //ajax
}); //click

// 상세전적, 보기 버튼 외 영역 클릭시 #record-detail-wrapper 사라지게 하기
var html = document.querySelector("html");
html.addEventListener('click', clickHtmlEvent);

function clickHtmlEvent(event) {
	var target = event.target;
	
	// 1. #latest-result .btns 이면 pass
	let latestResultBtns = $("#latest-result .btns");
	for (let i = 0; i < latestResultBtns.length; i++) {
		if (target == latestResultBtns[i]) return;
	}
	
	// 2. #record-detail-wrapper 이면 pass
	if (target == $("#record-detail-wrapper")[0]) return;
	
	// 3. #record-detail-wrapper의 자손 태그이면 pass
	let recordDetailWrappers = $("#record-detail-wrapper *");
	for (let i = 0; i < recordDetailWrappers.length; i++) {
		if (target == recordDetailWrappers[i]) return;
	}
	
	$("#record-detail-wrapper").css("display", "none");
}
