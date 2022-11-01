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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>boardList.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #list{
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="list">
    <table class="table table-hover text-center">
    <tr>
        <th>글 번호</th>
        <th>글 제목</th>
        <th>작성자</th>
        <th>작성일자</th>
        <th>조회수</th>
    </tr>
        <c:forEach items="${boardList}" var="board">
        <tr>
            <td>${board.id}</td>
            <td><a href="/board?id=${board.id}">${board.boardTitle}</a></td>
            <td>${board.boardWriter}</td>
            <td>
                    <fmt:formatDate value="${board.boardCreateData}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate>
            </td>
            <td>${board.boardHits}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
