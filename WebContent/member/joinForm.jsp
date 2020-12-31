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
        <h1>sign up</h1>
        <form action="board.do" name="frm" method="POST">
        <input type="hidden" name="command" value="join">
            <table>
                <tr>
                    <th>id</th>
                    <td>
                        <input type="text" name="userid" id="userid" size="20"> *
                        <input type="button" value="check" onclick="idCheck();">
                        <input type="hidden" name="reid">
                    </td>
                </tr>
                <tr>
                    <th>name</th>
                    <td>
                        <input type="text" name="name" id="name"> *
                    </td>
                </tr>
                <tr>
                    <th>pwd</th>
                    <td>
                        <input type="password" name="pwd" id="pwd" > *
                    </td>
                </tr>
                <tr>
                    <th>repwd</th>
                    <td>
                        <input type="password" name="repwd" id="repwd" > *
                    </td>
                </tr>
                <tr>
                    <th>email</th>
                    <td>
                        <input type="text" name="email" id="email" size="30"> *
                    </td>
                </tr>
                <tr>
                    <th>phone</th>
                    <td>
                        <input type="text" name="phone" id="phone" size="20">
                    </td>
                </tr>
                <tr>
                    <th>grade</th>
                    <td>
                        <label for="admin_0">
                            <input type="radio" name="admin" value="0" id="admin_0" checked> user
                        </label>
                        <label for="admin_1">
                            <input type="radio" name="admin" value="1" id="admin_1"> admin
                        </label>
                    </td>
                </tr>
            </table>
            <br><br>
            <input type="submit" value="join" onclick="return joinCheck();">
            <input type="reset" value="clear">
            <input type="button" value="back" onclick="location.href='board.do?command=loginForm'">
        </form>
    </div>
    
</body>
</html>