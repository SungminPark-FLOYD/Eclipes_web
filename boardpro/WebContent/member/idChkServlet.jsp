
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="com.google.gson.Gson" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberServiceImpl service = MemberServiceImpl.getInstance();

    //데이터 읽기
    StringBuffer buf = new StringBuffer();
    String line = null;

    BufferedReader br  = request.getReader();
    while ((line = br.readLine()) != null){
        buf.append(line);
    }

    String reqData = buf.toString();

    //역직렬화 - 객체 형태로 변환
    Gson gson = new Gson();
    MemberVo memId = gson.fromJson(reqData, MemberVo.class);

    String res = service.selectById(memId.getMem_id());

    request.setAttribute("res", res);

    request.getRequestDispatcher("/member/idView.jsp").forward(request, response);
%>
