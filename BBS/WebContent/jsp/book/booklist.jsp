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
				<th withd="200">표지</th>
				<th withd="150">출판일자</th>
				<th withd="100">금액</th>
				<th withd="100">출판사</th>
				<th withd="100">도서 소개</th>
			</tr>
			<c:forEach var="book" items="${booklist }">
				<tr>
					<td>${book.book_no }</td>
					<td>${book.book_name }</td>
					<td>${book.book_coverimg }</td>
					<td>${book.book_date }</td>
					<td>${book.book_price}</td>
					<td>${book.book_publisher }</td>
					<td>${book.book_info}</td>
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