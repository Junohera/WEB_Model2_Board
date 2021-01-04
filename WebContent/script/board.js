function loginCheck() {
	if (login.userid.value.length < 4) {
		login.userid.focus();
		alert("userid");
		return false;
	}
	if (login.pwd.value.length < 4) {
		login.pwd.focus();
		alert("pwd");
		return false;
	}
	return true;
};
	
function boardCheck() {
	if (document.frm.pass.value === "") {
		alert("pass");
		frm.pass.focus();
		return false;
	}
	if (document.frm.title.value === "") {
		alert("title");
		frm.title.focus();
		return false;
	}
	if (document.frm.content.value === "") {
		alert("content");
		frm.content.focus();
		return false;
	}
	if (document.frm.email.value === "") {
		alert("email");
		frm.email.focus();
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

function idok(userid) {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
};

function editCheck() {

	// 이름, 암호, 암호확인
	if (document.frm.name.value === "" || document.frm.name.length < 4) {
		alert("name");
		document.frm.name.focus();
		return false;
	}

	if (document.frm.pwd.value === "" || document.pwd.name.length < 4) {
		alert("pwd");
		document.pwd.name.focus();
		return false;
	}

	if (document.frm.pwd_check.value !== document.frm.pwd.value) {
		alert("pwd_check");
		document.frm.pwd_check.focus();
		return false;
	}
	
	return true;
};

function open_win(url, name) {
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=230";
	window.open(url, name, opt);
	// 'board.do?command=boardpassform&num=${board.num}','update'
};