<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    function idok(userid) {
        opener.frm.userid.value = document.frm.userid.value;
        opener.frm.reid.value = document.frm.userid.value;
        self.close();
    };
</script>
</head>
<body>
    <form action="board.do" method="GET" name="frm">
    	<input type="hidden" name="command" value="idcheck">
        id : <input type="text" name="userid" id="userid" value="${userid}" size="20">
        <input type="submit" value="check">
    </form>
    <c:if test="${result == 1}">
        ${userid} is already.
        <script>
            opener.document.frm.userid.value = "";
        </script>
    </c:if>
    <c:if test="${result == 0}">
        ${userid} is available.
        <input type="button" value="use" onclick="idok('${userid}');">
    </c:if>
</body>
</html>