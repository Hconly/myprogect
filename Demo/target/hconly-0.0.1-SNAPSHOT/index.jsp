<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
      <%--easyui--%>
    <link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
    <script type="text/javascript" src="js/easyui/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/index.css">
  </head>
  <body class="easyui-layout">

  <div data-options="region:'north',title:'用户界面',split:true" style="height:100px;"></div>
  <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
  <div data-options="region:'west',iconCls:'icon-reload',title:'菜单',split:true" style="width:100px;">

  </div>
  <div data-options="region:'east',title:'备注',split:true" style="width:100px;"></div>
  <div data-options="region:'center',title:'操作界面'" style="padding:5px;background:#eee;">
      <div id="tt" class="easyui-tabs" style="width:100%;height:100%;">
          <div title="用户添加" style="padding:20px;display:none;">
              <form id="ff" method="post" action="${pageContext.request.contextPath}/save.action">
                  <div>
                      <label for="name">姓名:</label>
                      <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
                  </div>
                  <div>
                      <label for="gender">性别:</label>
                      <input class="easyui-validatebox" type="text" name="gender" data-options="required:true" />
                  </div>
                  <div>
                      <label for="address">住址:</label>
                      <input class="easyui-validatebox" type="text" name="address" data-options="required:true" />
                  </div>
                  <div>
                      <label for="phone">电话:</label>
                      <input class="easyui-validatebox" type="text" name="phone" data-options="required:true" />
                  </div>
                  <div>
                      <label for="money">余额:</label>
                      <input class="easyui-validatebox" type="text" name="money" data-options="required:true" />
                  </div>
                  <input type="submit" value="提交" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">
                  <input type="reset" value="重置" class="easyui-linkbutton" data-options="iconCls:'icon-redo'">
              </form>
          </div>
          <div title="用户查询" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">
              <form id="find" method="post" action="${pageContext.request.contextPath}/find.action">
                  <div>
                      <label for="id">编号:</label>
                      <input class="easyui-validatebox" type="text" name="id" data-options="required:true" />
                  </div>
                  <input type="submit" value="提交" class="easyui-linkbutton" data-options="iconCls:'icon-search'">
              </form>
          </div>
          <script src="js/jquery-1.7.2.js"></script>
          <script>

          </script>
      </div>
  </div>
  </body>
</html>
<body>

