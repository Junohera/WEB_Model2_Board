package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";
		
		MemberDTO member = new MemberDTO();
		member.setName(request.getParameter("name"));
		member.setUserid(request.getParameter("userid"));
		member.setPwd(request.getParameter("pwd"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setAdmin(request.getParameter("admin"));
		
		if (MemberDAO.getIst().updateMember(member)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
		} else {
		}
		
		
		
		// sendredirect로 바꿔서 새로고침해보기 (양식 다시제출컨펌확인 )
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
