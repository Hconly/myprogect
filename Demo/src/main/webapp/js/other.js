//查询
	/*$("#btn").click(function() {
		var cc = $("#cc").combobox('getValue');
		var cont = $("#qu_con").val();
		$('#dg').datagrid({
			url : 'find.action?cc='+cc+"&cont="+cont,
			fitColumns : true,
			cache:false,
			columns : [ [
				{field : 'id',title : '序号',width : 100,align : 'center',hidden : true},
				{field : 'name',title : '姓名',width : 100,align : 'center'},
				{field : 'address',title : '地址',width : 100,align : 'center'},
				{field : 'phone',title : '电话',width : 100,align : 'center'},
			] ],
			pageNumber:1,    
			//pagination: true,     
			rownumbers: true,  
			pageSize: 4,    
			pageList: [4, 6,8],    
			//loader: myLoader,
		});
		//表格工具条
		$('#dg').datagrid({
			onDblClickRow:edit,
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
					if (row.length>0) {
						for (var i = 0; i < row.length; i++) {
							ids.push(row[i].id);
						}
						$.messager.confirm('警告', '确定要删除吗？', function(r) {
							if (r) {
								$.ajax({
									url : 'del.action?ids='+ids,
									type : "POST",
									cache:false,
									dataType: 'text',
									error : function() {
										$.messager.alert("提示信息", "删除成功", "info", function() {
											for (var i = 0; i < ids.length; i++) {
												$('#dg').datagrid('deleteRow', i);
											}
											$('#dg').datagrid('reload');
										});
									}
								})
							}else{
								$.messager.alert("提示信息", "已取消！", "info");
							}
						});
					}else{
						$.messager.alert("提示信息", "请选中要删除的行！", "info");
					}
				}
			}, '-', {
				text:'帮助',
				iconCls : 'icon-help',
				handler : function() {
					$.messager.alert("提示信息","敬请期待！",'info')
				}
			} ]
		});
	})*/