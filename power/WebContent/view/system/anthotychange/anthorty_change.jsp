<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="../../../head.jsp" %>
<script type="text/javascript">
	
	$(function(){
		$(".table tr td:first-child input").change(function(){
			var check= this.checked;
			$(this).parents("td").next().find("input").prop("checked",check);
		})
		
		$(".table tr td:last-child input").change(function(){
			
			if($(this).parents("td").find("input:checked").length>0){
				$(this).parents("tr").children("td:first").find("input").prop("checked",true);
			}else{
				$(this).parents("tr").children("td:first").find("input").prop("checked",false);
			}
			
		})
	})
	
</script>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>权限变更</li>
    </ul>
<form action="AnthortyRoleServelt" method="post" class="form-horizontal">
<input type="hidden" name="method" value="anthortyRoleSave">
<input type="hidden" name="roleid" value="${role.role_id }">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">角色编号</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${role.role_id }</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">角色名称</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${role.role_name }</p>
                </div>
            </div>
        </div>

    </div>
  <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">菜单信息</h5> 
  <table class="table">
  	<tr>
    	<th>一级菜单</th>
        <th>二三...级菜单</th>
    </tr>
    <c:forEach items="${anthortys }" var="info">
    <tr>
    	<td>
        	<label class="checkbox-inline">
            	<input type="checkbox" name="aid" ${info.checked ? 'checked' : '' } value="${info.anthorty_id }">${info.anthorty_name }
             </label>
        </td>
    	<td>
    		<c:forEach items="${info.childs }" var="c">
        	 <label class="checkbox-inline">
            	<input type="checkbox" name="aid" ${c.checked ? 'checked' : '' } value="${c.anthorty_id }">${c.anthorty_name }
             </label>
             </c:forEach>
        </td>
    </tr>    
   </c:forEach>
  
  </table>   
       	<div class="row">
    	<div class="col-sm-5 col-sm-offset-4">
          	<input type="submit" class="btn btn-success" value="权限变更"/>
            <a  href="anthorty_changelist.html" class="btn btn-warning">返回上一级</a>
          
        </div>
    </div>
    
</form>        
</div>
</body>
</html>
