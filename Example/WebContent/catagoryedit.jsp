<%@page import="java.util.List"%>
<%@page import="org.lq.question.entity.OlstCatagory"%>
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
	OlstCatagory catagory = (OlstCatagory)request.getAttribute("catagory");
%>
<div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改课程</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="updateCatagoryServlet">        
      <div class="form-group">
        <div class="label">
          <label>编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="id" value="<%=catagory.getId() %>" readonly />
          <div class="tips"></div>
        </div>
      </div>        
      <div class="form-group">
        <div class="label">
          <label>知识点：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="content" value="<%=catagory.getContent()%>"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>课程名称：</label>
        </div>
        <div class="field">
          <select class="input" name="pid">
			<option value="0">--请选择科目--</option>
			<%
			List<OlstCatagory> parnets=	(List<OlstCatagory>)request.getAttribute("parents");
			for(OlstCatagory p : parnets){
				%>
				<option value="<%=p.getId()%>" <%=p.getId() == catagory.getPid()?"selected":"" %>><%=p.getContent() %></option>
				<%
			}
			%>			
			</select>
        </div>
      </div>
      
     
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>