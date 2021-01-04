package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String pass = request.getParameter("pass");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDTO board = BoardDAO.getIst().getBoardOne(num);
		if (board.getPass().equals(pass)) {
			url = "board/checkSuccess.jsp";
			// request.setAttribute("message", "pass equal");
		} else {
			url = "board/boardCheckPass.jsp";
			request.setAttribute("message", "pass not equal");
		}

		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
