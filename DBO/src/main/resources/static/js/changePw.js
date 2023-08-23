/**
 * 
 */

//비밀번호 유효성 검사
function isPasswordValid(password) {
	// 조건 1: 영문대소문자 + 숫자 조합
	const regex1 = /^(?=.*[a-zA-Z])(?=.*\d).{8,16}$/;
	// 조건 2: 영문대소문자 + 특수문자 조합
	const regex2 = /^(?=.*[a-zA-Z])(?=.*[\W_]).{8,16}$/;
	// 조건 3: 숫자 + 특수문자 조합
	const regex3 = /^(?=.*\d)(?=.*[\W_]).{8,16}$/;
	
	return regex1.test(password) || regex2.test(password) || regex3.test(password);
}
$("#change").click(function() {
	let curPw = $("#curPw").val();
	let newPw1 = $("#newPw1").val();
	let newPw2 = $("#newPw2").val();
	if (curPw === "") {
		alert("현재 비밀번호를 입력해주세요.");
		$("#curPw").focus();
	}
	else if (newPw1 === "") {
		alert("새 비밀번호를 입력해주세요.");
		$("#newPw1").focus();
	}
	else if (newPw2 === "") {
		alert("새 비밀번호 확인을 입력해주세요.");
		$("#newPw2").focus();
	}
	else if (!isPasswordValid(newPw1)) {
		alert("비밀번호는 영문 대소문자/숫자/특수문자 중 2가지 이상 조합으로 8자~16자로 설정해주세요.");
		$("#newPw1").val("");
		$("#newPw2").val("");
		$("#newPw1").focus();
	} 
	else {
		$.ajax({
			url: "/updatePw",
			data: {
				"curPw": curPw,
				"newPw1": newPw1,
				"newPw2": newPw2,
			},
			dataType: "json",
			method: "post",
			success: function(response) {
				if (response.updateResult === -1) {
					alert("세션이 만료되어 로그아웃 되었습니다.");
					location.href = "/maintest";
					self.close();
				}
				else if (response.updateResult === -2) {
					alert("현재 비밀번호가 맞지 않습니다.");
				}
				else if (response.updateResult === -3) {
					alert("비밀번호 확인이 같지 않습니다.");
				}
				else if (response.updateResult === -4) {
					alert("현재 비밀번호와 같은 비밀번호로는 변경할 수 없습니다.")
				}
				else if (response.updateResult === 1) {
					alert("정상적으로 비밀번호가 변경되었습니다.");
					opener.location.reload();
					self.close();
				}
				else {
					alert("알 수 없는 이유로 비밀번호가 변경되지 않았습니다. 다시 시도해주세요.");
					self.close();
				}
			},
			error: function(request,error) {
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
		}); //ajax
	}
}); //click
$("#cancel").click(function() {
	self.close();
}); //click

$("#curPw").keydown(function(e) {
	if (e.keyCode === 13) $("#change").click();
});
$("#newPw1").keydown(function(e) {
	if (e.keyCode === 13) $("#change").click();
});
$("#newPw2").keydown(function(e) {
	if (e.keyCode === 13) $("#change").click();
});