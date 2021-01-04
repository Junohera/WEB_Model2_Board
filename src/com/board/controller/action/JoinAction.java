package com.board.controller.action;

import java.io.IOException;
import java.net.URLEncoder;

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
		String message = null;
		String userid = null;
		
		if (result == 1) {
			message = "sign up complete. do login";
			userid = member.getUserid();
		} else {
			message = "sign up fail, Please try again later.";
		}
		
		// 데이터 요청 후 또다시 request에 갖고 있던 값을 초기화하기 위해, forward가 아닌 sendredirect로 페이지 이동
		response.sendRedirect("board.do?command=loginForm&userid=" + userid);
	}

}
