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


@WebServlet("/ReplyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String reqdata = StreamData.dataChange(request);
		
		//역 직렬화
		Gson gson = new Gson();
		ReplyVo rvo = gson.fromJson(reqdata, ReplyVo.class);
		
		IBoardService service = BoardServiceImpl.getInstance();
		int res = service.updateReply(rvo);
		
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
