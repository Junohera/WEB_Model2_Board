package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.MemberDAO;
import com.board.dto.MemberDTO;

public class EditMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO member = new MemberDTO();
		member.setName(request.getParameter("name"));
		member.setUserid(request.getParameter("userid"));
		member.setPwd(request.getParameter("pwd"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setAdmin(Integer.parseInt(request.getParameter("admin")));
		MemberDAO.getIst().updateMember(member);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", member);		
		
		// RequestDispatcher dp = request.getRequestDispatcher("board.do?command=boardList");
		// dp.forward(request, response);
		
		new BoardListAction().execute(request, response);
	}

}
