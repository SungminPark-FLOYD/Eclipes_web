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


@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String reqdata = StreamData.dataChange(request);
		
		Gson gson = new Gson();
		BoardVo bvo = gson.fromJson(reqdata, BoardVo.class);
		//ip 주소 설정
		bvo.setWip(request.getRemoteAddr());
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int res = service.updateBoard(bvo);
		
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
