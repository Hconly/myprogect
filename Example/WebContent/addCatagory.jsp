<%@page import="org.lq.question.entity.OlstCatagory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/pintuer.css" />
		<link rel="stylesheet" type="text/css" href="css/tree.css" />
		<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/pintuer.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/treescroll.min.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			body{
				padding: 10px;
			}
		</style>
	</head>

	<body>
	
	<%
	Object msg= request.getAttribute("error_msg");
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
	
		<div class="line">
			<div class="x4">
				<div class="panel">
					<div class="panel-head">
						分类展示
					</div>
					<div class="treebox panel-body">
						<div class="tree">
							<ul>
							<%
							List<OlstCatagory> parents= (List<OlstCatagory>)request.getAttribute("parentList");
							List<OlstCatagory> list= (List<OlstCatagory>)request.getAttribute("catagoryList");
							
							for(OlstCatagory p : parents){
								// 输出父节点
								%>
								<li>
									<div class="close_menu"><span></span>
										<a title="<%=p.getContent()%>"><%=p.getContent()%></a>
									</div>
									<ul>
								<%
								for(OlstCatagory c : list){
									if(c.getPid() == p.getId()){
										
										%>
											<li>
												<a title="<%=c.getContent()%>"><%=c.getContent()%></a>
											</li>
										<%
									}
								}
								%>
								</ul>
								</li>
								<%
								
							}
							
							%>
								
									

							</ul>
						</div>
					</div>

				</div>
			</div>
			<div class="x7 x1-move">
				<div class="panel">
					<div class="panel-head bg-sub">
						分类展示
					</div>
					<div class="panel-body">

						<form action="AddCatagoryServlet" class="form-x">
							<div class="form-group" id="f_1541503882399">
								<div class="label">
									<label for="f_class">课程名称</label>
								</div>
								<div class="field">
									<select class="input" id="f_class" name="pid" data-validate="required:请选择,length#>=1:至少选择1项">
										<option value="0">--课程根目录--</option>
										<%
											List<OlstCatagory> parnets= (List<OlstCatagory>)request.getAttribute("parentList");
											if(parnets != null){
											
												for(OlstCatagory p :parnets){
													
													%>												
													<option value="<%=p.getId() %>"><%=p.getContent() %></option>
													<%
												}
											}	
										%>
									</select>
								</div>
							</div>
							<div class="form-group" id="f_1541503890828">
								<div class="label">
									<label for="f_username_txt">知识点</label>
								</div>
								<div class="field">
									<input type="text" class="input" id="f_username_txt" name="content" maxlength="50" value="" data-validate="required:请填写知识点内容,length#<50:字数在0-50个" placeholder="英文字母开头的字母、下划线、数字">
								</div>
							</div>
							<div class="form-group" id="f_1541503895338">
								<button class="button bg-red">添加</button>
								<button type="reset" class="button bg-gray">重置</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</body>

</html>