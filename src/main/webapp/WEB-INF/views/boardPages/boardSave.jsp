<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성하기</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #writer-form{
            margin-top: 5px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
    <div class="container" id="writer-form">
        <form action="/board/save" method="post" enctype="multipart/form-data">
            <input type="text" name="boardTitle" class="form-control" placeholder="제목"><br>
            <input type="text" name="boardWriter" class="form-control" placeholder="작성자"><br>
            <input type="text" name="boardPass" class="form-control" placeholder="글비밀번호"><br>
            <textarea name="boardContents" cols="30" rows="10" class="form-control" placeholder="내용을 입력하세요"></textarea>
            <input type="file" class="form-control" name="boardFile">
            <input type="submit" value="작성" class="btn btn-primary">
        </form>
    </div>
</body>

</html>
