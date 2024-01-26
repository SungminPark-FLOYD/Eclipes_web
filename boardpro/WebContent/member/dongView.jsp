<%@page import="kr.or.ddit.member.vo.ZipVo"%>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.google.gson.GsonBuilder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setContentType("application/json;charset=UTF-8"); %>

<%
    List<ZipVo> list = (List<ZipVo>) request.getAttribute("list");

    //list를 json형태의 문자열로 직렬화 보내기

//    Gson gson = new Gson();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String res = gson.toJson(list);

    PrintWriter ot = response.getWriter();
    ot.print(res);
    ot.flush();
%>

