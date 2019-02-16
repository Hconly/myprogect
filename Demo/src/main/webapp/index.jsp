<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<title>首页-CRUD测试</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">   
<link rel="stylesheet" type="text/css" href="js/index.css"> 
<link rel="icon" href="ooopic_1547192177.png" sizes="32x32">  
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>   
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="js/index.js"></script> 
<style type="text/css">
	#add_ff div{
	margin: 20px;
	}
	#que_ff div{
	margin: 20px;
	}
	#up_ff div{
	margin: 20px;
	}
</style> 
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',title:'欢迎界面',split:true,collapsed:true"  style="height:130px;">
    	<h2 style="color: skyblue"><marquee behavior="alternate" scrollamount="8" onmouseover=this.stop() onmouseout=this.start()>欢迎登录</marquee> </h2>
    </div>   
    <div data-options="region:'south',title:'今日推荐',split:true" style="height:150px;">
    	<div id="main_tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">   
		    <div title="首页" style="padding:20px;">   
		        
		    </div>  
		</div>
    </div>   
    <div data-options="region:'east',title:'备注',split:true" style="width:130px;"></div>   
    <div data-options="region:'west',title:'菜单',iconCls:'icon-reload',split:true" style="width:200px;">
		<ul id="t_menu" class="easyui-tree">
            <li>
                <span>主菜单</span>
                <ul  class="easyui-tree" >
                    <li><span>Test1</span></li>
                    <li><span>Test2</span></li>
                    <li><span>Test3</span></li>
 </ul>
	</div>   
    <div data-options="region:'center',title:'主界面'" style="padding:5px;background:#eee;">
        <!--增加界面 -->
      	<hr>
        <form id="add_ff" method="post" action="save.action">   
		    <div>   
		        <label for="name">姓名:</label>   
		        <input class="easyui-validatebox easyui-textbox" type="text" name="name" data-options="required:true" />   
		    </div>   
		    <div>   
		        <label for="email">地址:</label>   
		        <input class="easyui-validatebox easyui-textbox" type="text" name="address" data-options="required:true" />   
		    </div>    
		    <div>   
		        <label for="email">电话:</label>   
		        <input class="easyui-validatebox easyui-textbox" type="text" name="phone" data-options="required:true" />   
		    </div> 
		    <div> 
		    <a id="sub" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="margin-left: 25px">确认</a> 
		    <a id="res" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="margin-left: 25px">重置</a>
		    </div>
	    </form> 
	    
	    <!--查询界面 
      	<hr> 
      	<div>  
			    请选择要查询的项目：<br>
			 <select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
			    <option value="name">姓名</option>   
			    <option value="address">地址</option>   
			    <option value="phone">电话</option>     
			 </select> 
		</div>
		<div>
			 请输入要查询的关键字：<br>
	        <input id="qu_con" class="easyui-validatebox easyui-textbox" type="text"/>   
		    <button id="btn" type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-left: 25px">查询</button>
		</div>
		 -->
		<hr>
		<h4>请选择查询条件</h4> 
		<input id="ss"></input> 
		<div id="mm" style="width:80px"> 
		<div style="width:80px" data-options="name:'name',selected:true,iconCls:'icon-user'">姓名</div> 
		<div style="width:80px" data-options="name:'address',iconCls:'icon-addr'">地址</div> 
		<div style="width:80px" data-options="name:'phone',iconCls:'icon-phone'">电话</div> 
		</div>
		<hr>
		<!--查询返回的数据表格  -->
		<div>
			<table id="dg" border="0"></table>  
		</div>
		<div id="dd"></div>
    </div> 
</body>  
</html>