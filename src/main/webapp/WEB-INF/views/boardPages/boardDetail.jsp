<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오전 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>boardDetail.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <style>
    #detail{
      width: 800px;
      margin-top: 50px;
    }
  </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="detail">
  <table class="table table-hover">
<tr>
  <th>글번호</th>
  <td>${board.id}</td>
  </tr>

    <tr>
  <th>작성자</th>
    <td>${board.boardWriter}</td>
    </tr>
    <tr>
  <th>글 비밀번호</th>
    <td>${board.boardPass}</td>
    </tr>
    <tr>
  <th>제목</th>
    <td>${board.boardTitle}</td>
    </tr>
    <tr>
  <th>글 내용</th>
    <td>${board.boardContents}</td>
    </tr>

    <c:if test="${board.storedFileName != null}">
    <tr>
      <th>file</th>
      <td><img src="${pageContext.request.contextPath}/upload/${board.storedFileName}" alt="" width="100" height="100">
      </td>

    </tr>
    </c:if>

    <tr>
  <th>작성시간</th>
    <td>${board.boardCreateData}</td>
    </tr>
    <tr>
  <th>조회수</th>
    <td>${board.boardHits}</td>
    </tr>

  </table>
  <button class="btn btn-dark" onclick="listFn()">목록</button>
  <button class="btn btn-primary" onclick="updateFn()">수정</button>
  <button class="btn btn-danger" onclick="deleteFn()">삭제</button>

</div>
</body>
<script>
  const listFn =() =>{
    const page = '${page}';
    location.href = "/board/paging?page=" + page;
  }
  const updateFn = () => {
    const id = '${board.id}';
    location.href = "/board/update?id="+id;
  }
  const deleteFn = () => {
    const id = '${board.id}';
    location.href = "/board/deleteCheck?id="+id;
  }
</script>
</html>
