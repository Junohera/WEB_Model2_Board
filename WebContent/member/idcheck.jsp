<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">
<script src="script/board.js"></script>
</head>
<body>
    <form action="board.do" method="POST" name="frm">
    	<input type="hidden" name="command" value="idcheck">
        id : <input type="text" name="userid" id="userid" value="${userid}" size="20">
        <input type="submit" value="check">
    </form>
    <c:choose>
        <c:when test="${result == 0}">
        	${userid} is available.
            <input type="button" value="use" onclick="idok('${userid}');">
        </c:when>
        <c:otherwise>
            ${userid} is already.
            <script>
                opener.document.frm.userid.value = "";
            </script>
        </c:otherwise>
    </c:choose>
</body>
</html>