<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<style type="text/css">
.mydiv{
	width:200px;
	margin: 0 auto;
}
.inp{
	position:relative;
	width: 200px;
	margin-top:20px;
	margin-left: -250px;
	left: 50%;
}
.mysub{
	width: 150px;
	position: absolute;
	margin-left: -75px;
	left: 50%;
}
.st{
	margin-top:20px;
}
</style>
</head>
<body>
<div class="mydiv">
<form action="EmpServlet" method="post">
<input type="hidden" name="method" value="${empty updatEmp ? 'add' : 'update' }">
<input type="hidden" name="empno" value="${updatEmp.empno }">
			<table>
				<tr>
					<td><input name="ename" required="required" placeholder="请输入员工名称" value="${updatEmp.ename }" class="form-control inp"></td>
				</tr>
				<tr>
					<td><input name="job" required="required"
						placeholder="请输入员工职位" value="${updatEmp.job }" class="form-control inp"></td>
				</tr>
				<tr>
					<td>
					<select name="mgr" class="selectpicker st show-tick form-control">
							<option class="form-control inp">--请选择上司--</option>
							<c:forEach items="${emps }" var="e">
							<option ${e.empno == updatEmp.mgr ? "selected":"" } value="${e.empno }">${e.ename }</option>EmpServlet?method=editemp
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td><input name="hiredate" type="date" required="required"
						value="<ftm:formatDate value="${updatEmp.hiredate }" pattern="yyyy-MM-dd"/>" class="form-control inp">${updatEmp.hiredate }
					</td>
				</tr>
				<tr>
					<td><input name="sal" type="number" min="1"
						placeholder="请输入员工工资" required="required" value="${updatEmp.sal }" class="form-control inp">
					</td>
				</tr>
				<tr>
					<td><input name="comm" type="number" min="0"
						placeholder="请输入员工绩效" required="required"
						value="${updatEmp.comm }" class="form-control inp"></td>
				</tr>
				<tr>
					<td><select name="deptno" class="selectpicker st show-tick form-control">
							<option>--请求选择部门--</option>
							<c:forEach items="${depts }" var="d">
								<option ${d.deptno == updatEmp.deptno ? 'selected' : '' }
									value="${d.deptno }">${d.dname }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit" value="确认" class="btn btn-success">
					</td>
				</tr>
			</table>
		</form>
</div>
</body>
</html>