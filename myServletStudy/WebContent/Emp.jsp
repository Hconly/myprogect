<%@page import="java.util.List"%>
<%@page import="xxc.entity.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<style type="text/css">
	
</style>
</head>
<body>
	<c:forEach items="${userList }" var="user" varStatus="status">
		<table class="table">
			<tr>
				<td>${status.index+1 }</td>
				<td>${user.empno }</td>
				<td>${user.ename }</td>
				<td>${user.sal }</td>
				<td><a href="EmpServlet?id=${user.empno }">删除</a></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>