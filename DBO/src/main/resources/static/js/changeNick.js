/**
 * 
 */

$("#change").click(function() {
	if ($("#newNick").val() === "") {
		alert("변경할 닉네임을 입력해주세요.");
		$("#newNick").focus();
	} 
	else if($("#newNick").val().length > 30) {
		alert("닉네임이 너무 길어 변경할 수 없습니다.");
		$("#newNick").focus();
	} 
	else {
		$.ajax({
			url: "/updateNick",
			data: {
				"newNick": $("#newNick").val(),
			},
			dataType: "json",
			method: "post",
			success: function(response) {
				if (response.updateResult === -1) {
					alert("세션이 만료되어 로그아웃 되었습니다.");
					location.href = "/maintest";
					self.close();
				}
				else if (response.updateReuslt === -2) {
					alert("현재 닉네임과 같은 닉네임으로는 변경할 수 없습니다.");
				}
				else if (response.updateResult === 1) {
					alert("정상적으로 닉네임이 변경되었습니다.");
					opener.location.reload();
					self.close();
				}
				else {
					alert("알 수 없는 이유로 닉네임이 변경되지 않았습니다. 다시 시도해주세요.");
					self.close();
				}
			},
			error: function(request,error) {
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
		}); //ajax
	} //else
}); //click
$("#cancel").click(function() {
	self.close();
}); //click