package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.ReplyDTO;

public class AddReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyDTO reply = new ReplyDTO();
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		reply.setUserid(request.getParameter("userid"));
		reply.setContent(request.getParameter("content"));
		reply.setBoardnum(boardnum);
		BoardDAO.getIst().insertReply(reply);
		response.sendRedirect("board.do?command=boardview&num=" + boardnum);
	}

}
