<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
	<%@ include file="../../../head.jsp" %>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>角色管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form action="RoleServlet" method="post" class="form-horizontal">
	<input type="hidden" name="method" value="like">
	<div class="col-sm-2">角色名称:</div>
    <div class="col-sm-3">
    	<input type="text" name="roleName" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='<%=basePath%>view/system/roleinfo/roleinfo_add.jsp'"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>角色编号</th>
            <th>角色名称</th>
            <th>角色描述</th>
             <th>操作</th>
        </tr>
        <c:forEach items="${roleList }" var="info">
        
        	<tr>
	        	<td>${info.role_id }</td>
	            <td>${info.role_name }</td>
	            <td>${info.role_desc }</td>
	            <th><a href="RoleServlet?method=byid&id=${info.role_id }">修改</a> <a href="RoleServlet?method=delete&id=${info.role_id }">删除</a></th>
	        </tr>
        
        </c:forEach>
       	
          
    </table>
</div>

</body>
</html>
