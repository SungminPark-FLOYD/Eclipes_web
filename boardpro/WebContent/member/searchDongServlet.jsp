
<%@page import="kr.or.ddit.member.vo.ZipVo"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //요청시 전송 데이터 받기
    request.setCharacterEncoding("utf-8");
    String dong = request.getParameter("dong");
    //service객체 얻기
    IMemberService service = MemberServiceImpl.getInstance();
    //service메소드 호출 - 결과값 받기
    List<ZipVo> list = service.selectByDong(dong);

    //결과값을 request에 저장
    request.setAttribute("list", list);
    //view페이지로 이동
    request.getRequestDispatcher("/member/dongView.jsp").forward(request,response);

%>
