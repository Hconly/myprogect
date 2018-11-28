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
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>权限管理</li>
    </ul>
</div>
<div class="row">
	<div class="col-sm-2"  style="padding-left:30px;">
		<div id="mytree"></div>
    	<script type="text/jscript">
    		// 页面重绘 https://www.jb51.net/article/129715.htm 
    		//同步
	    	$.ajaxSetup({ 
	    	    async : false 
	    	});  
    		d = new dTree('d');
        	d.add(0,-1,'根目录');
        	$.post("<%=basePath%>AnthortyInfoServelt?method=findAll",function(data){
        		for(var i=0;i<data.length;i++){
        			var info = data[i];
        			d.add(info.anthorty_id,info.anthorty_pid,info.anthorty_name,'<%=basePath%>AnthortyInfoServelt?method=show&id='+info.anthorty_id,info.anthorty_desc,'mainiframe');
        		}
        		document.write(d);
        	},"json");
        	
        	//document.write(d);
        	
        </script>
    </div>
    <div class="col-sm-10">
    	<iframe id="mainframe" name="mainiframe"  style="width:100%; border:0px; " ></iframe>
        <script type="text/javascript">
        	var height = jQuery(window).height()-50;
			jQuery("#mainframe").attr("height",height+"px");
        	jQuery("#mainframe").attr("src","<%=basePath%>AnthortyInfoServelt?method=findParent");
        	
        </script>
        
    </div>

</div>


</body>
</html>
