$(document).ready(function() {
	var userlogin = '<%=session.getAttribute("userlogin")%>';
	if (userlogin != "null") {
		window.history.forward();
	}
	
	const loginForm = document.getElementById("login_form");	
	const loginBtn = document.getElementById("login_submit_btn");
	const loginId = document.getElementById("member_id");
	const loginPassword= document.getElementById("member_pw");
	
	$("#login_submit_btn").on('click', function(event){
		 	event.preventDefault();
		 	
		 	 var errorContainer = $("#Error");
		 	 
		        errorContainer.text("");

		 // 둘 다 입력되지 않은 경우
		 	  if (loginId.value.trim() === "" && loginPassword.value.trim() === "") {
		 	    errorContainer.text("아이디와 비밀번호를 모두 입력해 주세요.");
		 	    errorContainer.show();
		 	  } else if(loginId.value.trim() === "" || loginPassword.value.trim() === "") {
		 		 errorContainer.text("빈칸을 입력해 주세요.");
			 	    errorContainer.show();
		 	  } else {
		 	    errorContainer.hide();// 모든 조건이 만족되면 경고창 숨기기
		 	    loginForm.submit();
		 	  }
		});

	  //엔터로 다음칸 가기 : (순서) 아이디-> pw-> 로그인버튼
	  loginId.addEventListener("keydown", function(event) {
	    if (event.keyCode === 13) {
	      event.preventDefault(); 
	      loginPassword.focus();
	    }
	  });

	  loginPassword.addEventListener("keydown", function(event) {
	    if (event.keyCode === 13) {
	      event.preventDefault(); 
	      loginBtn.click(); 
	    }
	    });
});

window.addEventListener("DOMContentLoaded", function() {
	  var checkbox = document.getElementById("member_check_save_id0");
	  var backgroundUrlOff = "/img/key.svg"; 
	  var backgroundUrlOn = "/img/lock-2.svg";
	  var inputId = document.getElementById("member_id");

	  function saveIdToLocalStorage() {
	    try {
	      if (checkbox.checked) {
	        var savedId = inputId.value;
	        localStorage.setItem("savedId", savedId);
	      } else {
	        localStorage.removeItem("savedId");
	      }
	    } catch (error) {
	      console.error("Error accessing local storage:", error);
	    }
	  }

	  function updateCheckboxStyle() {
	    checkbox.style.backgroundImage = checkbox.checked ? "url(" + backgroundUrlOn + ")" : "url(" + backgroundUrlOff + ")";
	  }

	  checkbox.addEventListener("change", function() {
	    updateCheckboxStyle();
	    saveIdToLocalStorage();
	  });

	  inputId.addEventListener("input", function() {
	    updateCheckboxStyle();
	    saveIdToLocalStorage();
	  });

	  try {
	    var savedId = localStorage.getItem("savedId");
	    if (savedId) {
	      inputId.value = savedId;
	      checkbox.checked = true;
	      updateCheckboxStyle();
	    }
	  } catch (error) {
	    console.error("Error accessing local storage:", error);
	  }
	});