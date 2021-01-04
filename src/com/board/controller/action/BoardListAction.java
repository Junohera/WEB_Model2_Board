package com.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;
import com.board.util.Paging;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";
		
		/** <paging> */
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		Paging pagingUtil = new Paging();
		pagingUtil.setPage(page);
		
		int total = BoardDAO.getIst().selectAllCount();
		pagingUtil.setTotalCount(total);
		
		/** </paging> */
		
		ArrayList<BoardDTO> boardList = BoardDAO.getIst().selectAll(pagingUtil);
		request.setAttribute("boardList", boardList);
		request.setAttribute("pagingUtil", pagingUtil);
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
