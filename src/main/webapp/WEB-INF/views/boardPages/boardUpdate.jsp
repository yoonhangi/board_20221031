
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오후 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardUpdate.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #update-form {
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container"id="update-form">
    <form action="/board/update" method="post" name="updateForm">
<%-- hidden 화면에는 안보이지만  --%>
        글번호: <input type="text" name="id" value="${board.id}" class="form-control" readonly>
        작성자: <input type="text"  name='boardWriter' value="${board.boardWriter}" class="form-control" readonly>
        비밀번호: <input type="text" name="boardPass" id="boardPass" class="form-control">
        제목: <input type="text" name="boardTitle" value="${board.boardTitle}" class="form-control">
        내용: <textarea name="boardContents" id="" cols="30" rows="10" class="form-control">${board.boardContents}</textarea>
        <input type="button" value="수정" onclick="update()" class="btn btn-danger">
    </form>
</div>
</body>
<script>
    const update=()=>{
        const passDB = '${board.boardPass}';
        const pass = document.getElementById("boardPass").value;
        if (passDB == pass) {
            document.updateForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다.")
        }
    }
</script>
</html>
