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
        <input type="button" value="modify">
        <input type="button" value="delete">
    </div>
    
</body>
</html>