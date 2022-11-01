<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오전 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardDetail.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <table class="table table-hover">
<tr>
  <th>제목</th>
  <th>글 내용</th>
  <th>글 비밀번호</th>
  <th>작성자</th>
</tr>
<tr>
  <td>${board.boardTitle}</td>
  <td>${board.boardContents}</td>
  <td>${board.boardPass}</td>
  <td>${board.boardWriter}</td>
</tr>
  </table>
</div>
</body>
</html>
