<%@page import="test.entity.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	//当前数据
	List<Emp> list = (List<Emp>)request.getAttribute("emps");
	 Object index = request.getAttribute("pageIndex");
	 Object totalPageObj = request.getAttribute("totalPage");
	 Object totalCount = request.getAttribute("totalCount");
	 
	 int pageIndex =1;
	 int totalPage=1;
	 if(index!=null){
		 pageIndex = Integer.valueOf(index+"");
	 }
	 if(totalPageObj!=null){
		 totalPage = Integer.valueOf(totalPageObj+"");
	 }

%>


	<h1>这是员工界面</h1>
	<table border="1" style="width: 80%">
		<tr>
			<th>#</th>
			<th>编号</th>
			<th>员工姓名</th>
			<th>上司</th>
			<th>职位</th>
			<th>工资</th>
			<th>奖金</th>
			<th>入职日期</th>
			<th>部门编号</th>
			<th>操作</th>
		</tr>
		<%
			int row = 1;
			for(Emp e : list){
				%>
				<tr>
					<td><%=row++ %></td>
					<td><%=e.getEmpNo() %></td>
					<td><%=e.getEname() %></td>
					<td><%=e.getMgr() %></td>
					<td><%=e.getJob() %></td>
					<td><%=e.getSal() %></td>
					<td><%=e.getComm() %></td>
					<td><%=e.getHiredate() %></td>
					<td><%=e.getDno() %></td>
					<td>
						<a href="#">修改</a>
						<a href="#">删除</a>
					</td>
				</tr>
				<%
			}
		%>
		<tr>
			<td colspan="9" align="center">
			总行数:<%=totalCount %>--
				总页数:<%=totalPage %>/<%=pageIndex %>
				<a href="EmpServlet?index=1">首页</a>
				<a href="EmpServlet?index=<%=pageIndex<=1 ? 1 : pageIndex-1 %>">上一页</a>/
				<a href="EmpServlet?index=<%=pageIndex >=totalPage ? totalPage : pageIndex+1 %>">下一页</a>
				<a href="EmpServlet?index=<%=totalPage%>">尾页</a>
				<form action="EmpServlet" >
				<input size="1" name="index" type="number" max="<%=totalPage%>" min="1"><input type="submit" value="跳转">
				</form>
				
			</td>
		</tr>
	</table>

</body>
</html>