<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<style type="text/css">
	.my{
	width: 1000px;
	margin: 30px auto;
}
.inp{
	position:relative;
	width: 500px;
	margin-top:20px;
	margin-left: -250px;
	left: 50%;
}
.mysub{
	width: 150px;
	position: absolute;
	margin-left: -75px;
	margin-top:20px;
	left: 50%;
}
</style>
</head>

<body>
	<div class="my">
		<form action="DeptServlet?method=update" method="post">
			<input name="no" placeholder="请输入编号" value="${dept.deptno }" readonly="readonly" class="form-control inp">
			<input type="text" placeholder="请输入部门名称" name="dname" value="${dept.dname }" required class="form-control inp">
			<input type="text" placeholder="请输入地址" name="loc" value="${dept.loc }" required class="form-control inp">
			<input type="submit" value="修改" class="btn btn-success mysub">
		</form>
	</div>
</body>
</html>