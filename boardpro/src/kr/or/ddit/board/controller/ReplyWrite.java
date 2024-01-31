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
import kr.or.ddit.board.vo.ReplyVo;


@WebServlet("/ReplyWrite.do")
public class ReplyWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//요청시 전송 데이터 받기
//		String bonum = request.getParameter("bonum");
		
		String reqdata = StreamData.dataChange(request);
		
		//역직렬화
		Gson gson = new Gson();
		ReplyVo rvo = gson.fromJson(reqdata, ReplyVo.class);
		
		//service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//메소드 호출
		int res = service.insertReply(rvo);
		
		//request에 저장
		request.setAttribute("res", res);
		//view페이지로 이름 
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
