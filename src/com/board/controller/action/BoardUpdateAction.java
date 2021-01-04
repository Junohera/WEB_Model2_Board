package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO board = new BoardDTO();
		board.setNum(Integer.parseInt(request.getParameter("num")));
		board.setPass(request.getParameter("pass"));
		board.setEmail(request.getParameter("email"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));

		BoardDAO.getIst().updateBoard(board);

		new BoardListAction().execute(request, response);
	}

}
