<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../menu/mainmenu2.jsp"></jsp:include>
	<hr>
	<div align="center">
	<div>도서 조회/수정</div>
	<div>
		<table border="1">
			<tr>
				<th withd="100">도서번호</th>
				<th withd="100">도서명</th>
				<th withd="200">대여 총계</th>
				<th withd="150">대여 횟수</th>
			</tr>
			<c:forEach var="rent" items="${rent }">
				<tr>
					<td>${rent.book_no }</td>
					<td>${rent.book_name }</td>
					<td>${rent.rent_price }</td>
					<td>${rent.rent_status }</td>
				</tr>

			</c:forEach>
		</table>
	</div>
	</div>
<footer>
<jsp:include page="../menu/h.jsp"></jsp:include>
</footer>
</body>
</html>