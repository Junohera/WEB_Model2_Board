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
        <h1>사용자 수정</h1>
        <form action="board.do" method="POST" name="frm">
        	<input type="hidden" name="command" value="editMember">
            <table>
                <tr>
                    <th>id</th>
                    <td>
                        ${loginUser.userid}
                        <input type="hidden" name="userid" value="${loginUser.userid}">
                    </td>
                </tr>
                <tr>
                    <th>pwd</th>
                    <td>
                        <input type="password" name="pwd" size="20"> *
                    </td>
                </tr>
                <tr>
                    <th>repwd</th>
                    <td>
                        <input type="password" name="pwd_check" size="20"> *
                    </td>
                </tr>
                <tr>
                    <th>name</th>
                    <td>
                        <input type="text" name="name" size="20" value="${loginUser.name}"> *
                    </td>
                </tr>
                <tr>
                    <th>phone</th>
                    <td>
                        <input type="text" name="phone" size="20" value="${loginUser.phone}">
                    </td>
                </tr>
                <tr>
                    <th>email</th>
                    <td>
                        <input type="text" name="email" size="20" value="${loginUser.email}">
                    </td>
                </tr>
                <tr>
                    <th>grade</th>
                    <td>
                        <c:choose>
                            <c:when test="${loginUser.admin == 0}">
                                <label for="admin_0">
                                    <input type="radio" name="admin" value="0" id="admin_0" checked="checked"> user
                                </label>
                                <label for="admin_1">
                                    <input type="radio" name="admin" value="1" id="admin_1"> admin
                                </label>
                            </c:when>
                            <c:otherwise>
                                <label for="admin_0">
                                    <input type="radio" name="admin" value="0" id="admin_0"> user
                                </label>
                                <label for="admin_1">
                                    <input type="radio" name="admin" value="1" id="admin_1" checked="checked"> admin
                                </label>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
            <input type="submit" value="update" onclick="return editCheck();">
            <input type="reset" value="clear">
            <input type="button" value="list" onclick="location.href='board.do?command=boardList'">
        </form>
    </div>
</body>
</html>