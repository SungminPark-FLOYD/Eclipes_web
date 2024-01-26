<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="../css/logpro.css">

</head>
<body>
 
	<%-- -. 서버측 include가 아닌 클라이언트측의 include라 생각하면 간단하다
	즉 출력 결과만(html코드)을 include 한다
	-. include 되는 페이지와 변수를 같이 사용할 수 없다
	-. get 방식으로 파라미터를 전달 할수 없다
	 
	 <jsp:include page="b.jsp" flush="true"/>
	 a.jsp 결과에 b.jsp 가 실행된 결과가 include 된다
	 
     flush -. true : 문서의 출력 결과를 항상 버퍼내에서 갱신 하라는 의미이다
     
	 즉 따로따로 실행 된 후 그 결과(html)만을 가지고 include 한다
	 
	<!-- <jsp:include> 액션 태그는 페이지를 모듈화할때 사용된다. -->
 --%>
<header>
	
	<div class="dlog">
	    <jsp:include page="/start/logpro.jsp"/>
	</div> 
	
    <br>
    <a href="<%= request.getContextPath() %>/member/join.html" target="iboard">회원가입</a>&nbsp;&nbsp;&nbsp;
    <a href="<%= request.getContextPath() %>/board/board.jsp" target="iboard">게시판</a>
    <br><br>
</header>

<section >
  <iframe name="iboard" src="<%= request.getContextPath() %>/board/board.jsp"></iframe>
</section>


</body>
</html>








