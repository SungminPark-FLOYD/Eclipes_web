<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 저장한 데이터 꺼내기
	List<BoardVo> list = (List<BoardVo>)request.getAttribute("list");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int totalPage = (int)request.getAttribute("totalPage");
	
	//여러가지 데이터를 json형식으로 변환하기 위한 라이브러리
	JsonObject obj = new JsonObject();
	obj.addProperty("sp", startPage);
	obj.addProperty("ep", endPage);
	obj.addProperty("tp", totalPage);
		
	Gson gson = new Gson();
	JsonElement je = gson.toJsonTree(list);
	/* String result = gson.toJson(list); */
	/* out.print(result); */
	obj.add("je", je);
	out.print(obj);
	out.flush();

%>