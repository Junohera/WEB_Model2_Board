package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardView.jsp";
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO boardDAO = BoardDAO.getIst();
		
		boardDAO.updateReadCount(num);
		BoardDTO board = boardDAO.getBoardOne(num);
		request.setAttribute("board", board);
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
