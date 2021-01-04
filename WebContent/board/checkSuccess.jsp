<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<script>
	if (window.name === "update") {
		/* 게시물 수정폼으로 이동 */
		window.opener.location.href="board.do?command=boardupdateform&num=${param.num}";
	} else if (window.name === "delete") {
		/* 게시물 삭제폼으로 이동 */
		window.opener.location.href="board.do?command=boardDelete&num=${param.num}";
	} else {}
	self.close();
</script>

</body>
</html>