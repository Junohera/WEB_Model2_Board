package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.MemberDAO;
import com.board.dto.MemberDTO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO member = new MemberDTO();
		member.setName(request.getParameter("name"));
		member.setUserid(request.getParameter("userid"));
		member.setPwd(request.getParameter("pwd"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		int result = MemberDAO.getIst().addMember(member);
		
		if (result == 1) {
			request.setAttribute("message", "sign up complete. do login");
			request.setAttribute("userid", member.getUserid());
		}
		else request.setAttribute("message", "sign up fail, Please try again later.");
		
		RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
		dp.forward(request, response);
	}

}
