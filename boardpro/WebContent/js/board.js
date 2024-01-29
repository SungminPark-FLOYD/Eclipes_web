/**
 * 
 */

$.listPageServer = function() {
	//검색 type과 검색어 가져오기 - 최초 실행시에는 없다
	var vtype = $('#stype option:selected').val().trim();
	var vword = $('#sword').val().trim();
	$.ajax({
			url : `${myPath}/BoardList.do`,
			method : 'post',
			data : JSON.stringify({
				"page" : currentPage,
				"stype" : vtype,
				"sword" : vword
			}),
			success : function(res) {
				code = "";
				code += `<div class="container mt-3">
					  <div id="accordion">`;
				$.each(res.je, function(i, v) {							
				
					  code +=  `<div class="card">
					      <div class="card-header">
					        <a class="btn" data-bs-toggle="collapse" href="#collapse${v.num}">
					          ${v.subject}
					        </a>
					      </div>
					      <div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
					        <div class="card-body">
						        <div class="p12">
						        	<p class="p1">
						        		작성자 <span>${v.writer}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        		이메일<span>${v.mail}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        		조회수<span>0</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        		날짜<span>${v.wdate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						        	</p>
						        	<p class="p2">
						        		<input type="button" value="수정" name="modify" class="action">
						        		<input type="button" value="삭제" name="delect" class="action">
						        	</p>
						        </div> 
						        <p class="p3">
						        	내용출력 내용출력 내용출력<br>
						        	내용출력 내용출력 내용출력<br>
						        </p>
						        <p class="p4">
						        	<textarea rows="5" cols="50" class="area"></textarea>
						        	<input type="button" value="등록" name="reply" class="action">
						        </p>
						      </div>
						    </div>
						  </div>`;
						   }) //$.each반복문
			
					 code += `</div>
					</div>`;
					
					$('#result').html(code);
			},
			error : function(xhr) {
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
			
		})
}
