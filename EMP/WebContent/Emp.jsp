<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/pagination.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	.mydiv{
		width: 1000px;
		height: 600px;
		margin: 50px auto;
	}
	.tiaozhuan{
	width: 35%;
	margin: 0 auto;
	}
	.inp1{
	width: 60%;
	}
	.mysub{
	width: 15%;
	margin-left: 20px;
	height: 35px;
	}
	.mybtn{
	width: 15%;
	margin-left: 20px;
	height: 35px;
	}
	.h5{
	font-weight: bolder;
	}
</style>
</head>
<body>
	<c:if test="${empty page }">
		<script type="text/javascript">
			location.href = "EmpServlet?method=findAll";
		</script>
	</c:if>
	
	<div class="divider mydiv">
		<table class="table">
		
			<tr>
				<td colspan="10">
					<form action="EmpServlet" method="post">
						<input id="tj" name="ename" size="6" placeholder="请输入要查询的内容" value="${where }" class="form-control inp1" >
						<input type="submit" value="查询" class="btn btn-success mysub">
						<a href="EmpServlet?method=editemp" class="btn btn-info mybtn">添加</a>
					</form>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" align="left">查询结果</td>
				<td colspan="7" align="right">总页数：${page.totalPage }/总条数：${page.totalCount }</td>
			</tr>
			<tr>
				<th><h4 class="h4">编号</h4></th>
				<th><h4 class="h4">姓名</h4></th>
				<th><h4 class="h4">职位</h4></th>
				<th><h4 class="h4">上司</h4></th>
				<th><h4 class="h4">入职日期</h4></th>
				<th><h4 class="h4">工资</h4></th>
				<th><h4 class="h4">绩效</h4></th>
				<th><h4 class="h4">部门</h4></th>
				<th colspan="2" align="center"><h4 class="h4">操作</h4></th>
			</tr>
			<c:forEach items="${page.data }" var="e" varStatus="status">
				<tr>
					<td>${status.index }</td>
					<td>${e.empno }</td>
					<td>${e.ename }</td>
					<td>${e.job }</td>
					<td>${e.mgr }</td>
					<td>${e.hiredate }</td>
					<td>${e.sal }</td>
					<td>${e.comm }</td>
					<td>${e.deptno }</td>
					<td>
						<a href="EmpServlet?method=delete&empno=${e.empno }">删除</a>	
					</td>
					<td>
						<a href="EmpServlet?method=byid&empno=${e.empno }">修改</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="10">
					<div class="m-style tiaozhuan"></div>
				</td>
			</tr>
		</table>
	</div>

	<script type="text/javascript">
		$(".m-style").pagination({
							pageCount : '${page.totalPage}',
							current : '${page.pageIndex}',
							prevContent : '上一页',
							nextContent : '下一页',
							homePage : '首页',
							endPage : '尾页',
							jump : true,
							coping : true,
							callback : function(e) {
								var value = document.getElementById("tj").value;
								if (value == "") {
									location.href = "EmpServlet?method=findAll&index="
											+ e.getCurrent();
								} else {
									location.href = "EmpServlet?dname="
											+ value + "&method=like&index="
											+ e.getCurrent();
								}
							}
						});
	</script>
</body>
</html>
