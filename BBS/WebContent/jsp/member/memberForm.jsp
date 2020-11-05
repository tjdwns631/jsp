<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력화면</title>
</head>
<body>
	<jsp:include page="../menu/mainmenu.jsp"></jsp:include>
	<hr>
	<div align="center"></div>
	<div>
		<h1>회 원 가 입</h1>
	</div>
	<div>
		<form id="frm" name="frm" action="memberInsert.do" method="post" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<th width="150">아 이 디</th>
					<td width="500"><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<th width="150">패스워드</th>
					<td width="500"><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<th width="150">사진</th>
					<td ><input type="file" id="img" name="img"></td>
				</tr>
				<tr>
					<th width="150">이름</th>
					<td width="500"><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<th width="150">주소</th>
					<td width="500"><input type="text" id="address" name="address" size="200"></td>
				</tr>
				<tr>
					<th width="150">전화번호</th>
					<td width="500"><input type="text" id="tel" name="tel"
						></td>
				</tr>
				<tr>
					<th width="150">가입일자</th>
					<td width="500"><input type="date" id="enterdate"
						name="enterdate"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					  <input type="submit" val="가 입">&nbsp;&nbsp;
					  <input type="reset" val="취 소">
					</td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>