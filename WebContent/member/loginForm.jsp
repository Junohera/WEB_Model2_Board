<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="script/board.js"></script>
<style>
	.box {position: relative; width: 500px; height: 50px; margin: 0 auto; text-align: center; line-height: 50px;}
	.attr1 {position: relative; width: 248px; height: 48px; float: left; background: yellowgreen; font-size: 110%; text-align: center; line-height: 50px; border: 1px solid black;}
	.attr2 {position: relative; width: 248px; height: 48px; float: left; border: 1px solid yellowgreen; font-size: 110%; text-align: left; line-height: 50px;}
	#footer {position: relative; width: 500px; height: 50px; text-align: center; line-height: 50px;}
</style>
</head>
<body>
	<form action="board.do" method="post" name="login">
		<input type="hidden" name="command" value="login">
		<div class="box">
			<div id="title">login</div>
		</div>
		<div class="box">
			<div class="attr1">id</div>
			<div class="attr2">&nbsp;&nbsp;
				<input type="text" size="20" name="userid" style="width:200px; height:20px;" value="${param.userid}">
			</div>
		</div>
		<div class="box">
			<div class="attr1">pwd</div>
			<div class="attr2">&nbsp;&nbsp;
				<input type="password" size="20" name="pwd" style="width:200px; height:20px;">
			</div>
		</div>
		
		<div class="box">
			<div id="footer">
				<input type="submit" value="signIn" onclick="return loginCheck();">
				<input type="button" value="signUp" onclick="location.href='board.do?command=joinForm'">
			</div>
		</div>
		<div class="box">
			${message}
		</div>
	</form>
</body>
</html>