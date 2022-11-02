<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오전 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardDelete.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #delete-Check {
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div id="container" id="delete-Check">
        비밀번호: <input type="text" id="boardPass" placeholder="비밀번호를 입력하세요" class="form-control">
        <button class="btn btn-secondary" onclick="passCheck()">확인</button>
</div>

</body>
<script>
const passCheck=()=>{
    const passCheck = document.getElementById("boardPass").value;
    const passDB = '${board.boardPass}';
    const id = '${board.id}';
    if (passCheck== passDB) {
        location.href = "/board/delete?id="+id;
    } else {
        alert("비밀번호가 일치하지 않습니다.");
    }
}
</script>
</html>
