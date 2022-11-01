<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>boardList.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <table class="table table-hover">
    <tr>
        <th>글 제목</th>
        <th>작성자</th>
        <th>글 내용</th>
    </tr>
        <c:forEach items="${boardList}" var="board">
        <tr>
            <td><a href="/board?title=${board.boardTitle}">${board.boardTitle}</a></td>
            <td>${board.boardWriter}</td>
            <td>${board.boardContents}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
