<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        body {text-align: center;}
        #paging{font-size: 110%;}
    </style>
</head>
<body>
    <div id="paging">
        <c:url var="action" value="board.do?command=boardList"/>
        <c:if test="${param.prev}">
            <a href="${action}&page=${paging.beginPage - 1}">prev</a>
        </c:if>
        <c:forEach var="i" begin="${param.beginPage}" end="${param.endPage}">
            <c:choose>
                <c:when test="${param.page == index}">
                    ${i}&nbsp;
                </c:when>
                <c:otherwise>
                    <a href="${action}&page=${i}">
                        <span style="color: silver; font-weight: bold;">${i}</span>
                    </a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${param.next}">
            <a href="${action}&page=${paging.endPage + 1}">next</a>
        </c:if>
    </div>
</body>
</html>