<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="../css/board.css">
<script src="../js/board.js"></script>
<script src="../js/jquery.serializejson.min.js"></script>
<script>
<%
//로그인 체크 - sessio의 값을 가져오기 - 비교하기
	MemberVo vo = (MemberVo)session.getAttribute("loginok");
	//json 형태로 변환
	String ss = null;
	
	Gson gson = new Gson();
	if(vo != null) ss = gson.toJson(vo);
	/* ss = { "mem_id" : "a001",
			"mem_name" : "김은대"-
	} */
%>
	uvo = <%= ss%>;
	var currentPage = 1;
	var myPath = '<%= request.getContextPath()%>';
	$(document).ready(function () {
		//시작하자마자  listlistPageServer를 호출하여
		//결과를 출력한다
		$.listPageServer();
		
		//검색 이벤트
		$('#search').on('click', function(){
			$.listPageServer();
		})
		
		//next다음 이벤트
		$(document).on('click', '#next', function () {
			currentPage = parseInt($('.pageno').last().text()) + 1;
			$.listPageServer();
		})
		
		//prev이전 이벤트
		$(document).on('click', '#prev', function () {
			currentPage = parseInt($('.pageno').first().text()) - 1;
			$.listPageServer();
		})
		
		//페이지 번호.pageno 이벤트
		$(document).on('click', '.pageno', function(){
			currentPage = parseInt($(this).text());
			$.listPageServer();
		})
		
		//글쓰기 이벤트
		$('#write').on('click', function() {
			
			if(uvo == null) {
				alert("로그인하세요")
			}else {	
				$('#wModal').modal('show');
				$('#wname').val(uvo.mem_name);
			}
		})
		
		//글쓰기 전송 이벤트
		$('#wsend').on('click', function(){
			//입력한 모든 값을 가져온다
			fdata = $('#wform').serializeJSON();
			console.log(fdata);
			
			//서버로 전송
			$.boardWriteServer();
			
			//모달창 닫기
			$('.txt').val("");
			$('#wModal').modal('hide');
			
		})
	})
</script>

</head>
<body>
<h1>게시판</h1>
<input type="button" value="글쓰기" id="write"><br><br>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      <form class="d-flex">
      	<select class="form-select" id="stype">
      		<option value="">전체</option>
      		<option value="writer">작성자</option>
      		<option value="subject">제목</option>
      		<option value="content">내용</option>
      	</select>
      
        <input id="sword" class="form-control me-2" type="text" placeholder="Search">
        <button id="search" class="btn btn-primary" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>

<div id="result"></div>
<br><br>
<div id="pagelist"></div>
<br>
<!-- 글쓰기 modal-->
<div class="modal" id="wModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">글쓰기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <form name="wform" id="wform">
        	<label>제목</label>
        	<input type="text" class="txt" id="wsubject" name="subject"><br>
        	<label>이름</label>
        	<input type="text" class="txt" id="wname" name="writer" readonly><br>
        	<label>메일</label>
        	<input type="text" class="txt" id="wmail" name="mail"><br>
        	<label>비밀번호</label>
        	<input type="text" class="txt" id="wpassword" name="password"><br>
        	<label>내용</label><br>
        	<textarea rows="5" cols="50" class="txt" id="wcontent" name="content" class="content"></textarea><br><br>
        	<input type="submit" value="확인" id="wsend" class="btn btn-success"><br>
        </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
</body>
</html>