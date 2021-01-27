﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>JSTL sql:query Tag</title>
<style>
th {
	min-width: 130px;
}
</style>
<script src="./scripts/jquery-3.2.1.min.js"></script>
<script>
	function makeData() {
		let list = [];

		//체크한 행만 전송할 데이터 만들기. 은행계좌가 입력된 경우만 포함함.
		$("[name='selId']:checked").each(function(i, checkbox) {
			var tr = $(checkbox).parent().parent();
			var td = $(tr).children();
			var obj = {};

			var employee_id = td.eq(1).text();
			var bankAcct = td.eq(6).find("input").val();
			var salamon = parseInt(td.eq(3).text());
			var commi = parseInt(td.eq(4).text());
			//은행계좌가 없으면 skip
			if (bankAcct == '') {
				return;
			}
			//객체에 담기
			obj["slipAmount"] = salamon + commi; // 급여 + 상여금
			obj["salDt"] = '202101'; // 급여년월 (현재년월)
			obj["customer"] = employee_id; // 사번_이름
			obj["bankAcct"] = bankAcct; // 은행계좌

			//목록에 담기
			list.push(obj);
		});

		//객체를 string으로 변환
		console.log(JSON.stringify(list));

		//ajax 호출 
		$.ajax({
			url : '/spring/slip',
			data : JSON.stringify(list), //요청 파라미터(쿼리 문자열) 
			type : 'post',//요청method 타입 get or post default는 get
			contentType : 'application/json', //요청 파라미터 타입
			dataType : 'json', //응답결과 타입
			success : function(result) {
				alert("건수 : " + result.tcount);
			},
			error : function(xhr, status) {
				alert(status);
			}
		});

	}
</script>
</head>

<body>
	<!-- 데이터조회 시작 -->
	<sql:setDataSource var="snapshot" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="hr" password="hr" />

	<sql:query dataSource="${snapshot}" var="result">
            SELECT e.*, round(salary*commission_pct, 2) as commission, d.department_name 
              FROM Employees e, departments d 
             WHERE e.department_id =d.department_id 
               AND commission_pct>0
             ORDER BY first_name  
         </sql:query>
	<!-- 데이터조회 끝-->

	<button type="button" id="" onclick="makeData()">급여신청</button>
	<!-- 목록 시작  -->
	<table border="1" width="40%">
		<tr>
			<th><input type="checkbox" id="chkAll"></th>
			<th>Employee_id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Commission</th>
			<th>Deaprtment</th>
			<th>bank</th>
		</tr>

		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td align="center"><input type="checkbox" name="selId"></td>
				<td align="center"><c:out value="${row.employee_id}" /></td>
				<td><c:out value="${row.first_name} ${row.last_name}" /></td>
				<td align="right"><c:out value="${row.salary}" /></td>
				<td align="right"><c:out value="${row.commission}" /></td>
				<td align="center"><c:out value="${row.department_name}" /></td>
				<td><input type="text" name="bank"></td>
			</tr>
		</c:forEach>
	</table>
	<!-- 목록 끝  -->
</body>
</html>