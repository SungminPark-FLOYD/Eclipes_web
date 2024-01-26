
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="true" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.7.1.min.js"></script>
    <script>
        $(() => {


            $(document).on('click', '.ziptr', function (){
                zcode = $('td', this).eq(0).text(); //우편번호
                addr = $('td', this).eq(1).text();

                //부모 창에 input에 출력
                $('#zip',opener.document).val(zcode);
                $('#add1', opener.document).val(addr);
                window.close();
            })

            $('input[type=button]').on('click', ()=> {
                //입력한 동이름 가져오기
                dongvalue = $('#dong').val().trim();

                //입력여부
                if(dongvalue.length < 1){
                    alert("동 입력~~");
                    return false;
                }

                //서버로 전송
                $.ajax({
                    url:'/member/searchDongServlet.jsp',
                    data: {"dong" : dongvalue},
                    type : 'post',
                    success:function (res){
                        code = "<table>";
                        code += `<tr><td>우편번호</td>
                                     <td>주소</td>
                                     <td>번지</td></tr>`;

                        $.each(res, function(i, v) => {
                            bunji = v.bunji;
                            if(bunji == null) bunji = "";
                            code += `<tr class="ziptr"><td>${v.zipcode}</td><td>${v.sido} ${v.gugun} ${v.dong}</td><td>${bunji}</td></tr>`;
                        })
                        code += "</table>";

                        $('#result').html(code);
                    },
                    error:function (xhr){
                        alert("상태 : " + xhr.status)
                    },
                    dataType : 'json'
                })
            })
        })
    </script>
    <style>
        .ziptr:hover{
            background-color: lime;
        }
    </style>
</head>
<body>
<h2>우편번호 찾기</h2>
<label for="dong">동이름 입력</label>
<input type="text" id="dong">
<input type="button" value="확인">
<div id="result"></div>
</body>
</html>
