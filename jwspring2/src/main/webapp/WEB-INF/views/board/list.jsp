<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="content">
		<h2>글 목록</h2>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.id}</td>
					<td>${board.title}</td>
					<td>${board.user}</td>
					<td>${board.date}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>