package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;


@WebServlet("/BoardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송데이터 받기
		int num = Integer.parseInt(request.getParameter("num"));
		//service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
				
		//service메소드 호출 - int결과
		int res = service.deleteBoard(num);
		//결과를 저장
		request.setAttribute("res", res);
		
		//view페이지를 이동 - result.jsp
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
