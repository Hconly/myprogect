/**
 * index
 */
$(function() {
	//菜单
	$('#t_menu').tree({
		onClick : function(node) {
			if ($("#t_tab").tabs("getTab", node.text) == null) {
				$("#t_tab").tabs("add", {
					title : node.text,
					href : "do.jsp",
					closable : true,
					selected : true
				})
			} else {
				$("#t_tab").tabs("select", node.text)
			}
		}
	});

	//添加
	$("#sub").click(function() {
		$('#add_ff').form('submit', {
			onSubmit : function() {
				$.messager.progress({
					text : "正在保存...",
					interval : 200,
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.progress('close');
					$.messager.alert("提示信息", "请输入有效内容", 'warning')
				}
				return isValid;
			},
			success : function() {
				$.messager.alert("提示信息", "保存成功", 'info');
				$.messager.progress('close');
			}
		});
	});

	//添加-重置
	$('#res').click(function() {
		$("#add_ff").form('clear');
	});

	//查询
	$('#ss').searchbox({
		searcher : function(value, name) {
			$('#dg').datagrid({
				url : 'find.action?cc=' + name + "&cont=" + value,
				fitColumns : true,
				cache : false,
				columns : [ [
					{
						field : 'id',
						title : '序号',
						width : 100,
						align : 'center',
						hidden : true
					},
					{
						field : 'name',
						title : '姓名',
						width : 100,
						align : 'center'
					},
					{
						field : 'address',
						title : '地址',
						width : 100,
						align : 'center'
					},
					{
						field : 'phone',
						title : '电话',
						width : 100,
						align : 'center'
					},
				] ],
				pageNumber : 1,
				pagination : true,
				rownumbers : true,
				pageSize : 4,
				pageList : [ 4, 6, 8 ],
				loader : PageLoader, //分页加载函数
			});

			//工具栏-编辑-删除-帮助
			$('#dg').datagrid({
				toolbar : [ {
					text : "编辑",
					iconCls : 'icon-edit',
					handler : edit
				}, '-', {
					text : "删除",
					iconCls : 'icon-remove',
					handler : function() {
						var ids = [];
						var row = $('#dg').datagrid('getSelections');
						if (row.length > 0) {
							for (var i = 0; i < row.length; i++) {
								ids.push(row[i].id);
							}
							$.messager.confirm('警告', '确定要删除吗？', function(r) {
								if (r) {
									$.ajax({
										url : 'del.action?ids=' + ids,
										type : "POST",
										cache : false,
										dataType : 'text',
										error : function() {
											$.messager.alert("提示信息", "删除成功", "info", function() {
												for (var i = 0; i < ids.length; i++) {
													$('#dg').datagrid('deleteRow', i);
												}
												$('#dg').datagrid('reload');
											});
										}
									})
								} else {
									$.messager.alert("提示信息", "已取消！", "info");
								}
							});
						} else {
							$.messager.alert("提示信息", "请选中要删除的行！", "info");
						}
					}
				}, '-', {
					text : '帮助',
					iconCls : 'icon-help',
					handler : function() {
						$.messager.show({
							title:'提示消息',
							msg:'正在跳转百度...',
							showType:'show',
							timeout:1500,
							style:{
								top:document.body.scrollTop+document.documentElement.scrollTop+200,
							}
						});
						setTimeout(function() {
							window.open("http://www.baidu.com")
						}, 1500);
					}
				} ]
			});
		},
		width : 250,
		menu : '#mm',
		prompt : '请输入搜索关键字'
	});

	//修改-双击
	$('#dg').datagrid({
		onDblClickRow : function(index,row){
			$('#dd').dialog({
				title : '修改信息',
				width : 270,
				height : 275,
				closed : false,
				resizable : false,
				cache : false,
				href : 'up.jsp',
				modal : true,
				onLoad : function() {
					$("#up_name").textbox('setValue', row.name)
					$("#up_addr").textbox('setValue', row.address)
					$("#up_phone").textbox('setValue', row.phone)
				},
				buttons : [ {
					text : '保存',
					handler : function() {
						$.messager.progress({
							text : "正在保存...",
							interval : 250,
						});
						$('#up_ff').form('submit', {
							url : "upd.action?id=" + row.id,
							success : function(data) {
								$.messager.alert("提示信息", "修改成功", 'info');
								$.messager.progress('close');
								$("#dd").dialog('close');
								$('#dg').datagrid('updateRow', index);
								$('#dg').datagrid('reload');
							}
						});
					}
				}, {
					text : '关闭',
					handler : function() {
						$("#dd").dialog('close');
					}
				} ]
			});
			$('#dd').dialog("open");
		}
	})
	
	//修改-函数
	function edit() {
		var row = $('#dg').datagrid('getSelections');
		if (row.length == 1) {
			$('#dd').dialog({
				title : '修改信息',
				width : 270,
				height : 275,
				closed : false,
				resizable : false,
				cache : false,
				href : 'up.jsp',
				modal : true,
				onLoad : function() {
					$("#up_name").textbox('setValue', row[0].name)
					$("#up_addr").textbox('setValue', row[0].address)
					$("#up_phone").textbox('setValue', row[0].phone)
				},
				buttons : [ {
					text : '保存',
					handler : function() {
						$.messager.progress({
							text : "正在保存...",
							interval : 250,
						});
						$('#up_ff').form('submit', {
							url : "upd.action?id=" + row[0].id,
							success : function(data) {
								$.messager.alert("提示信息", "修改成功", 'info');
								$.messager.progress('close');
								$("#dd").dialog('close');
								$('#dg').datagrid('updateRow', 0);
								$('#dg').datagrid('reload');
							}
						});
					}
				}, {
					text : '关闭',
					handler : function() {
						$("#dd").dialog('close');
					}
				} ]
			});
			$('#dd').dialog("open");
		} else {
			$.messager.alert("提示信息", "请选择要修改的一项！", "info");
		}
	}

	//分页加载函数
	function PageLoader(param, success, error) {
		var that = $(this);
		var opts = that.datagrid("options");
		if (!opts.url) {
			return false;
		}
		$.ajax({
			type : opts.method,
			url : opts.url,
			data : param,
			dataType : "json",
			success : function(data) {
				that.data().datagrid['cache'] = data;
				success(bulidData(data));
			},
			error : function() {
				error.apply(this, arguments);
			}
		});
		function bulidData(data) {
			var temp = $.extend({}, data);
			var tempRows = [];
			var start = (param.page - 1) * parseInt(param.rows);
			var end = start + parseInt(param.rows);
			var rows = data.rows;
			for (var i = start; i < end; i++) {
				if (rows[i]) {
					tempRows.push(rows[i]);
				} else {
					break;
				}
			}
			temp.rows = tempRows;
			return temp;
		}
	};
	
	$('#t_menu').tree({    
	    onClick:function(node){
	    	if($("#main_tabs").tabs("getTab",node.text)==null){
		    	$('#main_tabs').tabs('add',{
		    		title: node.text,
		    		selected: true,
		    		closable:true
		    	});
			}else{
				$("#main_tabs").tabs("select",node.text);
			}
	    }
	});
})