<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>시작페이지</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

</head>
<body>
    <button class="btn btn-dark" onclick="save()">글작성</button>
</body>
<script>
    const save = () => {
        location.href = "/save";
    }
</script>
</html>
