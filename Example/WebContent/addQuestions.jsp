<%@page import="org.lq.question.entity.OlstCatagory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script src="js/jquery.js"></script>
		<script src="js/pintuer.js"></script>
	</head>

	<body class="bounce">
		
		<%
			//所有父标签
			List<OlstCatagory> parentList = (List<OlstCatagory>)request.getAttribute("parentList");
			//所有子标签
			List<OlstCatagory> catagoryList = (List<OlstCatagory>)request.getAttribute("catagoryList");
		%>

		<div class="tab">
			<div class="tab-head">
				<strong>试题添加</strong> <span class="tab-more"><a href="#">更多</a></span>
				<ul class="tab-nav">
					<li class="active">
						<a href="#tab-start">单选</a>
					</li>
					<li>
						<a href="#tab-css">多选</a>
					</li>
					<li>
						<a href="#tab-units">判断</a>
					</li>
					
				</ul>
			</div>
			<div class="tab-body">
				<!--
        	作者：181723953@qq.com
        	时间：2018-11-07
        	描述：单选开始
        -->
				<div class="tab-panel active" id="tab-start">
					<blockquote class="border-sub fadein">
						<p>
					<strong>单选</strong>
					<hr class="bg-red" />
					<form action="AddQuestionsServelt" class="form-x">
					<input type="hidden" name="quest_type" value="1">
						<div class="form-group">
							<div class="label">
								<label for="f_address_txt">试题类型</label>
							</div>
							<div class="field">
								<select class="input" name="quest_ctgr">
									<option value="0">--请选择--</option>
									<%
										for(OlstCatagory parent : parentList){
											%>
											<optgroup label="<%=parent.getContent()%>">
												<%
												for(OlstCatagory child : catagoryList){
													if(child.getPid() == parent.getId()){
														%>
														<option value="<%=child.getId()%>"><%=child.getContent() %></option>
														<%
													}
												}
												%>
											</optgroup>
											<%
										}
									%>
									
								</select>
							</div>
						</div>
						<div class="form-group" id="f_1541560119785">
							<div class="label">
								<label for="f_address_txt">题干</label></div>
							<div class="field">
								<textarea type="text" class="input" id="f_address_txt" name="question" maxlength="1000" value="" data-validate="required:请填写题干信息" placeholder="请输入主题干"></textarea>
							</div>
						</div>
						<div class="form-group" id="f_1541560156928">
							<div class="label">
								<label for="f_username_txt">A : </label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_A" maxlength="100" value="" data-validate="required:请填写选项,length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560158481">
							<div class="label">
								<label for="f_username_txt">B : </label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_B" maxlength="100" value="" data-validate="required:请填写选项,length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560159786">
							<div class="label">
								<label for="f_username_txt">C :</label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_C" maxlength="100" value="" data-validate="required:请填写选项,length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560160904">
							<div class="label">
								<label for="f_username_txt">D : </label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_D" maxlength="100" value="" data-validate="required:请填写选项,length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560161619">
							<div class="label">
								<label for="f_username_txt">E : </label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_E" maxlength="100" value="" data-validate="length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560687940">
							<div class="label">
								<label for="f_sex">答案 :</label></div>
							<div class="field">
								<div class="button-group radio">
									<label class="button">
						<input name="correct" value="A" type="radio"><span class="icon icon-check text-green"></span> A
					</label>
									<label class="button">
			          <input name="correct" value="B" type="radio" data-validate="required:选择答案,radio:请选择答案"><span class="icon icon-check text-green"></span>B</label>
									<label class="button">
			          <input name="correct" value="C" type="radio"  data-validate="required:选择答案,radio:请选择答案"><span class="icon icon-check text-green"></span>C</label>
									<label class="button">
			          <input name="correct" value="D" type="radio" data-validate="required:选择答案,radio:请选择答案"><span class="icon icon-check text-green"></span>D</label>
									<label class="button">
			          <input name="correct" value="E" type="radio" data-validate="required:选择答案,radio:请选择答案"><span class="icon icon-check text-green"></span>E</label></div>
							</div>
						</div>
						<div class="form-group" id="f_1541560159786">
							<div class="label">
								<label for="f_username_txt">描述</label></div>
							<div class="field">
								<textarea type="text" class="input" id="f_address_txt" name="descrpt" maxlength="1000" value="" data-validate="required:请填写题干信息" placeholder="请输入主题干"></textarea>
								</div>
						</div>
							
						
						<div style="text-align: center;">
							<button class="button bg-red">添加</button>
						</div>
					</form>
					</p>
</blockquote>
						
				</div>
				<!-- 单选 -->

				<!--
        	作者：181723953@qq.com
        	时间：2018-11-07
        	描述：多选开始
        -->
				<div class="tab-panel" id="tab-css">
					<blockquote class="border-main fadein-bottom">
						<p>
					<strong>多选</strong>
					<hr class="bg-red" />
					<form action="AddQuestionsServelt" class="form-x">
						<input type="hidden" name="quest_type" value="2">
						<div class="form-group">
							<div class="label">
								<label for="f_address_txt">试题类型</label>
							</div>
							<div class="field">
								<select class="input" name="quest_ctgr">
									<option value="0">--请选择--</option>
									<%
										for(OlstCatagory parent : parentList){
											%>
											<optgroup label="<%=parent.getContent()%>">
												<%
												for(OlstCatagory child : catagoryList){
													if(child.getPid() == parent.getId()){
														%>
														<option value="<%=child.getId()%>"><%=child.getContent() %></option>
														<%
													}
												}
												%>
											</optgroup>
											<%
										}
									%>
									
								</select>
							</div>
						</div>
						<div class="form-group" id="f_1541560119785">
							<div class="label">
								<label for="f_address_txt">题干</label></div>
							<div class="field">
								<textarea type="text" class="input" id="f_address_txt" name="question" maxlength="1000" value="" data-validate="required:请填写题干信息" placeholder="请输入主题干"></textarea>
							</div>
						</div>
						<div class="form-group" id="f_1541560156928">
							<div class="label">
								<label for="f_username_txt">A : </label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_A" maxlength="100" value="" data-validate="required:请填写选项,length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560158481">
							<div class="label">
								<label for="f_username_txt">B : </label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_B" maxlength="100" value="" data-validate="required:请填写选项,length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560159786">
							<div class="label">
								<label for="f_username_txt">C :</label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_C" maxlength="100" value="" data-validate="required:请填写选项,length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560160904">
							<div class="label">
								<label for="f_username_txt">D : </label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_D" maxlength="100" value="" data-validate="required:请填写选项,length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560161619">
							<div class="label">
								<label for="f_username_txt">E : </label></div>
							<div class="field">
								<input type="text" class="input" id="f_username_txt" name="option_E" maxlength="100" value="" data-validate="length#<100:字数在0-100个" placeholder="请填写选项内容"></div>
						</div>
						<div class="form-group" id="f_1541560687940">
							<div class="label">
								<label for="f_sex">答案 :</label></div>
							<div class="field">
								<div class="button-group checkbox">
									<label class="button">
						<input name="correct" value="A" type="checkbox"><span class="icon icon-check text-green"></span> A
					</label>
									<label class="button">
			          <input name="correct" value="B" type="checkbox" data-validate="required:选择答案"><span class="icon icon-check text-green"></span>B</label>
									<label class="button">
			          <input name="correct" value="C" type="checkbox"  data-validate="required:选择答案"><span class="icon icon-check text-green"></span>C</label>
									<label class="button">
			          <input name="correct" value="D" type="checkbox" data-validate="required:选择答案"><span class="icon icon-check text-green"></span>D</label>
									<label class="button">
			          <input name="correct" value="E" type="checkbox"  data-validate="required:选择答案"><span class="icon icon-check text-green"></span>E</label></div>
							</div>
						</div>
						<div class="form-group" id="f_1541560159786">
							<div class="label">
								<label for="f_username_txt">描述</label></div>
							<div class="field">
								<textarea type="text" class="input" id="f_address_txt" name="descrpt" maxlength="1000" value="" data-validate="required:请填写题干信息" placeholder="请输入主题干"></textarea>
								</div>
						</div>
						<div style="text-align: center;">
							<button class="button bg-red">添加</button>
						</div>
					</form>
					</p>
					</blockquote>
				</div>
				<!--
        	作者：181723953@qq.com
        	时间：2018-11-07
        	描述：判断题
        -->
				<div class="tab-panel" id="tab-units">
					<blockquote class="fadein-right">
						<p>
							<strong>.判断.</strong>
<hr class="bg-red" />
							<form action="AddQuestionsServelt" class="form-x" method="post">
							<input type="hidden" name="quest_type" value="3">
								<div class="form-group">
							<div class="label">
								<label for="f_address_txt">试题类型</label>
							</div>
							<div class="field">
								<select class="input" name="quest_ctgr">
									<option value="0">--请选择--</option>
									<%
										for(OlstCatagory parent : parentList){
											%>
											<optgroup label="<%=parent.getContent()%>">
												<%
												for(OlstCatagory child : catagoryList){
													if(child.getPid() == parent.getId()){
														%>
														<option value="<%=child.getId()%>"><%=child.getContent() %></option>
														<%
													}
												}
												%>
											</optgroup>
											<%
										}
									%>
									
								</select>
							</div>
						</div>
								<div class="form-group" id="f_1541560119785">
									<div class="label">
										<label for="f_address_txt">题干</label></div>
									<div class="field">
										<textarea type="text" class="input" id="f_address_txt" name="question" maxlength="100" value="" data-validate="required:请填写题干信息" placeholder="请输入主题干"></textarea>
									</div>
								</div>

								<div class="form-group" id="f_1541560687940">
									<div class="label">
										<label for="f_sex">答案 :</label></div>
									<div class="field">
										<div class="button-group radio">
											<label class="button active">
						<input name="correct" value="1" checked="checked" type="radio"><span class="icon icon-check text-green"></span> 对
					</label>
											<label class="button">
						<input name="correct" value="0" type="radio"><span class="icon icon-times"></span> 错
					</label>
										</div>
									</div>
									<div class="form-group" id="f_1541560159786">
							<div class="label">
								<label for="f_username_txt">描述</label></div>
							<div class="field">
								<textarea type="text" class="input" id="f_address_txt" name="descrpt" maxlength="1000" value="" data-validate="required:请填写题干信息" placeholder="请输入主题干"></textarea>
								</div>
						</div>
									<div style="text-align: center;">
										<button class="button bg-red">添加</button>
									</div>
							</form>

							</div>
				</div>
				</p>
				</blockquote>
		
		</div>

	</body>

</html>