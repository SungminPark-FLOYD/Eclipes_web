package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import config.StreamData;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVo;


@WebServlet("/BoardWrite.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//요청시 전송데이터 받기 - writer, subject, mail, password, content
		String reqdata = StreamData.dataChange(request);
		
		Gson gson = new Gson();
		BoardVo vo = gson.fromJson(reqdata, BoardVo.class); 
		vo.setWip(request.getRemoteAddr());
		
		//service객체
		IBoardService service = BoardServiceImpl.getInstance();
		
		//메소드 호출
		int res = service.insertBoard(vo);
		
		//request에 저장한다.
		request.setAttribute("res", res);
		
		//view페이지로 이동
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
