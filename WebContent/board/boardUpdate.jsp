<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">
<script src="script/board.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>modify</h1>
		<form name="frm" method="post" action="board.do">
			<input type="hidden" name="num" value="${board.num}">
			<input type="hidden" name="command" value="boardUpdate">
			<table>
				<tr>
					<th>author</th>
					<td>${board.userid}
						<input type="hidden" name="name" value="${loginUser.userid}">
					</td>
				</tr>
				<tr>
					<th>pass</th>
					<td>
						<input type="password" name="pass" id="pass" size="12" value="${board.pass}"> * required (when handling)
					</td>
				</tr>
				<tr>
					<th>email</th>
					<td>
						<input type="text" name="email" id="email" value="${board.email}">
					</td>
				</tr>
				<tr>
					<th>title</th>
					<td>
						<input type="text" name="title" id="title" value="${board.title}">
					</td>
				</tr>
				<tr>
					<th>content</th>
					<td>
						<textarea name="content" id="" cols="70" rows="15">
							${board.content}
						</textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="update" onclick="return boardCheck();">
			<input type="reset" value="clear">
			<input type="button" value="list" onclick="location.href='board.do?command=boardList'">
		</form>
	</div>
</body>
</html>