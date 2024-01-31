<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.board.vo.ReplyVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ReplyVo> list = (List<ReplyVo>)request.getAttribute("list");

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	String res = gson.toJson(list);
	
	out.print(res);
	out.flush();

%>