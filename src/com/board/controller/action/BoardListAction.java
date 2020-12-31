package com.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";
		ArrayList<BoardDTO> boardList = BoardDAO.getIst().selectAll();
		request.setAttribute("boardList", boardList);
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
