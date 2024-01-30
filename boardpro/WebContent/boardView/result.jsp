<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//controller에서 저장한 데이터 꺼내기
	int res = (int)request.getAttribute("res");

	if(res > 0){
	%>
	
	{
		"flag" : "성공"
	}
		
<%	}else { %>
	{
		"flag" : "실패"
	}

<%		
	}
%>