package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.google.gson.Gson;

import config.StreamData;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVo;


@WebServlet("/logProServlet.ddit")
public class LogProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqdata = StreamData.dataChange(request);
		//{"mem_id" : vid, "mem_pass" : vpass }
		
		//vo 객체로 역직렬화
		Gson gson = new Gson();
		MemberVo vo = gson.fromJson(reqdata, MemberVo.class);
		//vo.setMem_id(vid);
		//vo.setMem_pass(vpass);
		
		//service객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		//service메소드 호출 - 결과값 얻기
		MemberVo res = service.logSelect(vo);
		//session에 저장
		
		//view페이지로 이동 - logpro.jsp
	}

}
