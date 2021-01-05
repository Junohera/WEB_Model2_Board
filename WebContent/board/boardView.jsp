<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${empty loginUser}">
    :<jsp:forward page="board.do?command=loginForm" />
</c:if>
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
        <h1>board detail</h1>
        <table>
            <tr>
                <th>작성자</th>
                <td>${board.userid}</td>
                <th>이메일</th>
                <td>${board.email}</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td><fmt:formatDate value="${board.writedate}"></fmt:formatDate></td>
                <th>조회수</th>
                <td>${board.readcount}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td colspan="3">${board.title}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3"><pre>${board.content}</pre></td>
            </tr>
        </table>
        <br>
        <br>
        <input type="button" value="list" onclick="location.href='board.do?command=boardList'">
        <c:if test="${loginUser.userid == board.userid}">
            <input type="button" value="modify"
                onclick="open_win('board.do?command=boardpassform&num=${board.num}','update');"
            >
            <input type="button" value="delete"
                onclick="open_win('board.do?command=boardpassform&num=${board.num}','delete');"
            >
        </c:if>
    </div>
    
    <br>
    <!-- replyzoom -->
    <div id="wrap" align="center">
    <form action="board.do" method="post" name="frm2">
    <input type="hidden" name="command" value="addReply">
    <input type="hidden" name="boardnum" value="${board.num}">
        <table>
            <tr>
                <th>writter</th>
                <th>writeDate</th>
                <th>content</th>
                <th>&nbsp;</th>
            </tr>
            <tr align="center">
                <td width="100">
                    ${loginUser.userid}
                    <input type="hidden" name="userid" value="${loginUser.userid}">
                </td>
                <td width="100">
                    <c:set var="now" value="<%=new java.util.Date()%>"></c:set>
                    <fmt:formatDate value="${now}" pattern="MM/dd HH:mm"></fmt:formatDate>
                </td>
                <td width="670">
                    <input type="text" name="content" id="content" size="80">
                </td>
                <td width="100">
                    <input type="submit" value="send" onclick="return reply_check();">
                </td>
            </tr>
            
            <c:forEach var="reply" items="${replyList}" varStatus="status">
                <tr>
                    <td align="center">${reply.userid}</td>
                    <td align="center">
                        <fmt:formatDate value="${reply.writedate}" pattern="MM/dd HH:mm"></fmt:formatDate>
                    </td>
                    <td>${reply.content}</td>
                    <td align="center">
                        <c:if test="${loginUser.userid == reply.userid}">
                            <input type="button" value="delete"
                            onclick="location.href='board.do?command=deleteReply&num=${reply.num}&boardnum=${reply.boardnum}'">
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    </div>
</body>
</html>