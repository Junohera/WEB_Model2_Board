package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.MemberDAO;

public class IdcheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberDAO memberDAO = MemberDAO.getIst();
		int result = memberDAO.confirmId(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		RequestDispatcher dp = request.getRequestDispatcher("member/idcheck.jsp");
		dp.forward(request, response);
	}

}
