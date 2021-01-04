<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function passCheck() {
		if (document.frm.pass.value.length === 0) {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div align="center">
		<h1>check pass</h1>
		<form action="board.do" name="frm" action="get">
			<input type="hidden" name="command" value="boardCheckPass">
			<input type="hidden" name="num" value="${param.num}">
			<table style="width:80%;">
				<tr>
					<th>pass</th>
					<td>
						<input type="password" name="pass" id="pass" size="20">
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="next" onclick="return passCheck();">
			<br><br>${message}
		</form>
	</div>

</body>
</html>