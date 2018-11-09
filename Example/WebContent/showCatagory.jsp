<%@page import="org.lq.question.entity.OlstCatagory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<%
	Object msg= session.getAttribute("error_msg");
		if(msg !=null){
			%>
<div class="alert alert-red"><span class="close rotate-hover"></span><strong>提示：</strong><%=msg %></div>
			<%
		}
	%>
	<%
	Object success_msg= session.getAttribute("success_msg");
		if(success_msg !=null){
			%>
<div class="alert alert-green"><span class="close rotate-hover"></span><strong>提示：</strong><%=success_msg %></div>
			<%
		}
	%>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <div class="padding border-bottom">
    <button type="button" class="button border-yellow" onclick="window.location.href='GetParentCatagory'"><span class="icon-plus-square-o"></span> 添加分类</button>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>
      <th width="15%">课程名称</th>
      <th width="10%">父节点</th>
      <th width="10%">操作</th>
    </tr>
    <%
    List<OlstCatagory> list= (List<OlstCatagory>)request.getAttribute("list");
    for(OlstCatagory catagoru : list){
    	%>
    	 <tr>
	      <td><%=catagoru.getId() %></td>
	      <td><%=catagoru.getContent() %></td>
	      <td><%=catagoru.getParent() == null ? "根节点" :catagoru.getParent().getContent() %></td>
	      <td><div class="button-group"> <a class="button border-main" href="GetCatagoryByIdServlet?cid=<%=catagoru.getId()%>"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(<%=catagoru.getId()%>)"><span class="icon-trash-o"></span> 删除</a> </div></td>
	    </tr>
    	<%
    }
    %>
   
   
  </table>
</div>
<script type="text/javascript">
function del(id){
	if(confirm("您确定要删除吗?")){			
		location.href="deleteCatagoryServlet?id="+id;
	}
}
</script>

</body>
</html>