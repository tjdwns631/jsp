<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력화면</title>
</head>
<body>
	<jsp:include page="../menu/mainmenu2.jsp"></jsp:include>
	<hr>
	<div align="center"></div>
	<div align="center">
		<h1 >도서 등록</h1>
	</div>
	<div align="center">
		<form id="frm" name="frm" action="bookinsert.do" method="post" >
			<table border="1">
				<tr>
					<th width="150">도서명</th>
					<td ><input type="text" id="book_name" name="book_name"></td>
				</tr>
				<tr>
					<th width="150">도서표지</th>
					<td ><input type="text" id="book_coverimg" name="book_coverimg"></td>
				</tr>
				<tr>
					<th width="150">출판일자</th>
					<td ><input type="date" id="book_date" name="book_date"></td>
				</tr>
				<tr>
					<th width="150">금액</th>
					<td ><input type="text" id="book_price" name="book_price"></td>
				</tr>
				<tr>
					<th width="150">출판사</th>
					<td ><input type="text" id="book_publisher" name="book_publisher"
						></td>
				</tr>
				<tr>
					<th width="150">도서소개</th>
					<td ><input type="text" id="book_info"
						name="book_info"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					  <button type="submit" >등록</button>
					  <button type="button" onclick="book/booklist.jsp" >조회</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
<footer>
<jsp:include page="../menu/h.jsp"></jsp:include>
</footer>
</body>
</html>