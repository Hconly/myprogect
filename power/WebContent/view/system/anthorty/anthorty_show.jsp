<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@include file="../../../head.jsp" %>
</head>

<body>

<form action="" class="form-horizontal">
 	<div class="row">
    	<div class="col-xs-9 ">
          <input type="button"   class="btn btn-success"   value="添加权限信息" onClick="javascript:window.location='<%=basePath%>AnthortyInfoServelt?method=findParent'"/>
         	 <input  type="button" class="btn btn-info" value="修改权限信息"/>
        	<input  type="button" class="btn btn-danger" onclick="Javascript:window.location='<%=basePath%>AnthortyInfoServelt?method=delete&id=${anthorty.anthorty_id }'" value="删除权限信息"/>
          
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-xs-5">
        	<div class="form-group">
            	<label class="col-xs-3 control-label">权限编号</label>
                <div class="col-xs-9">
                	<p class="form-control-static">${anthorty.anthorty_id }</p>
                </div>
            </div>
        
        </div>
        <div class="col-xs-5">
            <div class="form-group">
            	<label class="col-xs-3 control-label">权限名称</label>
                <div class="col-xs-9">
                		<p class="form-control-static">${anthorty.anthorty_name }</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-xs-5">
        	<div class="form-group">
            	<label class="col-xs-3 control-label">上级权限</label>
                <div class="col-xs-9">
                	<p class="form-control-static">${anthorty.parent eq null ? '根目录' : anthorty.parent.anthorty_name}</p>
                </div>
            </div>
        
        </div>
        <div class="col-xs-5">
            <div class="form-group">
            	<label class="col-xs-3 control-label">权限URL</label>
                <div class="col-xs-9">
                	<p class="form-control-static">${anthorty.anthorty_url }</p>
                </div>
            </div>
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-xs-10">
        	<div class="form-group">
            	<label class="col-xs-3 control-label">备注</label>
                <div class="col-xs-9">
                	<p class="form-control-static">${anthorty.anthorty_desc }</p>
                </div>
            </div>
        
        </div>

    </div>


</form>

</body>
</html>
