package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDTO board = new BoardDTO();
		board.setUserid(userid);
		board.setPass(pass);
		board.setEmail(email);
		board.setTitle(title);
		board.setContent(content);

		BoardDAO.getIst().insertBoard(board);
		
		response.sendRedirect("board.do?command=boardList");
		// .forward(request, response)된 jsp는
		// 최종페이지(게시물이 추가된 페이지)에서 새로고침을 눌렀을때
		// boardWrite.jsp에서부터 전달된 request값들을 가지고 지금의 execute까지 실행합니다.
		// 새로고침 : 최종 페이지를 포워딩해준 execute부터 다시 실행한다는 뜻입니다.
		// 그래서 의도치않게 새로고침으로 방금 추가한 게시물이 하나 더 추가되는 결과가 생기게 됩니다.
		// 그래서 forward가 아니고 sendRedirect를 실행하여 forward로 연결될 수 있는 실행을
		// 끊어 줍니다.
	}

}
