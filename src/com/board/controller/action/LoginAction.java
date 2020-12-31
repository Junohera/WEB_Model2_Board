package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.MemberDAO;
import com.board.dto.MemberDTO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/loginForm.jsp";
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.getIst();
		MemberDTO member = dao.getMember(userid);
		
		
		
		if (member == null) {
			request.setAttribute("message", "아이디가 없습니다.");
		} else {
			if (member.getPwd() != null) {
				if (member.getPwd().equals(pwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("loginUser", member);
					url = "board.do?command=boardList";
				} else {
					request.setAttribute("message", "비밀번호가 다릅니다");
				}
			} else {
				request.setAttribute("message", "잘못된 회원정보입니다. 관리자에게 문의하세요");
			}
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
