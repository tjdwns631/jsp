<%@page import="co.micol.board.common.SessionListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/BBS/css/mainmenu.css">
</head>
<body>
<div align="center">
 <h1>도서 대여 관리</h1>
<div id="menu">
<nav id="topMenu" >
		<ul>
         <li><a class="menuLink" href="bookinsertForm.do">도서등록</a></li>
         <li>|</li>
         <li><a class="menuLink" href="booklist.do">도서목록조회/수정</a></li>
         <li>|</li>
         <li><a class="menuLink" href="rentlist.do">대여현황조회</a></li>
            <li>|</li>
            <li><a class="menuLink" href="main.do">홈으로</a></li>
		</ul>
	</nav>
</div>
</div>
</body>
</html>