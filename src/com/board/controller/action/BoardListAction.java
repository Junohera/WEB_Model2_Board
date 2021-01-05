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
		
		Paging pagingInfo = new Paging();
		pagingInfo.setPage(page);
		
		int total = BoardDAO.getIst().selectAllCount();
		pagingInfo.setTotalCount(total);
		
		/** </paging> */
		
		ArrayList<BoardDTO> boardList = BoardDAO.getIst().selectAll(pagingInfo);
		request.setAttribute("boardList", boardList);
		request.setAttribute("pagingInfo", pagingInfo);
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
