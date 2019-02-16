<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>My JSP 'up.jsp' starting page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>   
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="js/index.js"></script> 
</head>
<body>
<form id="up_ff" method="post">
	<div class="as">
		<label for="name">姓名:</label> 
		<input id="up_name" class="easyui-textbox" type="text" name="name" />
	</div>
	<div>
		<label for="email">地址:</label> 
		<input id="up_addr" class="easyui-textbox" type="text" name="address" />
	</div>
	<div>
		<label for="email">电话:</label> 
		<input id="up_phone" class="easyui-textbox" type="text" name="phone" />
	</div>
</form>
</body>
</html>
