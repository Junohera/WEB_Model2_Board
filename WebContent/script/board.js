function boardCheck() {
	if (document.form.pass.value === "") {
		alert("pass");
		form.pass.focus();
		return false;
	}
	if (document.form.title.value === "") {
		alert("title");
		form.title.focus();
		return false;
	}
	if (document.form.content.value === "") {
		alert("content");
		form.content.focus();
		return false;
	}
	if (document.form.email.value === "") {
		alert("email");
		form.email.focus();
		return false;
	}
	
	return true;
};

function idCheck() {
	/*
		userid란에 사용하고자 하는 아이디를 먼저 입력하고 중복체크 버튼을 누르게 하기 위해
		userid란에 내용이 없으면 아이디를 먼저 입력하라고 메시지를 출력합니다.
	*/
   if (document.frm.userid.value.length == 0) {
	   alert("Please enter your ID");
	   frm.userid.focus();
	   return false;
   }

   var inputid = document.frm.userid.value; // 입력한 아이디 추출
   var opt = "toolbar=no, scrollbars=no, resizable=no, width=500, height=200";
   // idcheck.do 에 먼저 갔다가 포워딩되어 온 페이지가 팝업창에 나타납니다.
   window.open("board.do?command=idcheck&userid=" + inputid, "idcheck", opt);
};

function joinCheck() {
	if (document.frm.name.value.length == 0) {
		alert("Please enter your name");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length < 4) {
		alert("ID must be at least four characters");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value.length == "") {
		alert("Password must be entered.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.repwd.value) {
		alert("Password do not match.");
		frm.repwd.focus();
		return false;
	}
	if (document.frm.reid.value != document.frm.userid.value) {
		alert("This is a duplicate check error.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.email.value === "") {
		alert("email must be entered.");
		frm.email.focus();
		return false;
	}

	return true;
};