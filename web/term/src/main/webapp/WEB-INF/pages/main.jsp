<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录页</title>
<%@ include file="/WEB-INF/pages/common/meta.jsp"%>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="overflow: hidden; padding: 20px">
		<h2>顶部标题区</h2>
	</div>
	<div data-options="region:'west',split:true" title="系统菜单" style="width: 200px;"></div>
	<div data-options="region:'center'" style="background: #fafafa; overflow: hidden">
		<div id="systemTabs" class="easyui-tabs" fit="true" border="false">
			<div id="firstTabs" title="系统首页" style="padding: 20px; overflow: hidden; heigth: 100%">
				系统首页文字说明
			</div>
		</div>
	</div>
</body>
</html>

