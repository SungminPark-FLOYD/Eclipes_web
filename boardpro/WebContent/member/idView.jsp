<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String res = (String) request.getAttribute("res");
    if(res == null){
        %>
        {
            "flag" : "사용가능 id"
        }
<%    }else { %>
        {
            "flag" : "사용 불가능 id"
        }

<%
    }
%>
