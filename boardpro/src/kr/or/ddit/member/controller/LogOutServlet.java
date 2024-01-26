package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.vo.MemberVo;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/LogOutServlet.ddit")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo) session.getAttribute("loginok");
		
		if(vo != null) {
			session.removeAttribute("check");
			session.removeAttribute("loginok");
		}
		//view페이지로 이동 - logpro.jsp
		request.getRequestDispatcher("/start/logpro.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
