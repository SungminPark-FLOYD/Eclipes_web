
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int res = (Integer) request.getAttribute("res");
    if(res > 0) { %>
{
    "flag" : "성공"
}
<%
    }else {
 %>
{
    "flag" : "실패"
}
<%
    }
%>