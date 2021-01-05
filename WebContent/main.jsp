<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${empty loginUser}">
    <jsp:forward page="board.do?command=loginForm"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
    <div id="wrap" align="center">
        <h1>board list</h1>
        <table class="list">
            <tr>
                <td colspan="5" style="border:white;text-align: right;">
                    <div style="float:left;">${loginUser.name}(${loginUser.userid})님 로그인
                        <input type="button" value="회원정보 수정" onclick="location.href='board.do?command=editmemberForm'">
                        <input type="button" value="로그아웃" onclick="location.href='board.do?command=logout'">
                    </div>
                    <div style="float: right;">
                        <a href="board.do?command=boardwriteform">게시글 등록</a>
                    </div>
                </td>
            </tr>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <c:forEach var="board" items="${boardList}" varStatus="status">
                <tr>
                	<td align="center">${board.num}</td>
                    <td><a href="board.do?command=boardview&num=${board.num}">${board.title}</a></td>
                    <td align="center">${board.userid}</td>
                    <td align="center"><fmt:formatDate value="${board.writedate}" pattern="yyyy.MM.dd"></fmt:formatDate></td>
                    <td align="center">${board.readcount}</td>
                </tr>
            </c:forEach>
        </table><br>
        
        <jsp:include page="/paging/paging.jsp">
            <jsp:param name="page" value="${pageing.page}"/>
            <jsp:param name="beginPage" value="${paging.beginPage}" />
            <jsp:param name="endPage" value="${paging.endPage}" />
            <jsp:param name="prev" value="${paging.prev}" />
            <jsp:param name="next" value="${paging.next}"/>
        </jsp:include>
        <%-- <div id="paging">
            <c:url var="action" value="board.do?command=boardList"></c:url>
            <c:if test="${paging.prev}"><a href="${action}&page=${paging.beginPage - 1}">prev</a></c:if>
            
           	<c:forEach var="index" begin="${paging.beginPage}" end="${paging.endPage}">
                <c:choose>
                    <c:when test="${paging.page == index}">
                        ${index}&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="${action}&page=${index}">${index}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            
            <c:if test="${paging.next}"><a href="${action}&page=${paging.endPage + 1}">next</a></c:if>
        </div> --%>
    </div>
	
</body>
</html>