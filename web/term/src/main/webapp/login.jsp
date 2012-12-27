<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录页</title>
<%@ include file="/WEB-INF/pages/common/meta.jsp"%>
<script>
	jQuery.noConflict();
	jQuery(document).ready(function() {
		jQuery.formValidator.initConfig({
			formid : "loginForm",
			onsuccess : function() {
				return true;
			},
			onerror : function(msg) {
				alert(msg)
			}
		});
		jQuery("#username").formValidator({
			empty : true,
			onshow : "请输入用户标识",
			onfocus : "请输入3-15个字符"
		}).inputValidator({
			min : 3,
			max : 15,
			onerror : "你输入的用户名非法,请确认"
		}).regexValidator({
			regexp : "^\\w+$",
			onerror : "请输入英文字符"
		});
		jQuery("#password").inputValidator({
			min : 3,
			max : 15,
			onerror : "你输入密码"
		});
	});
</script>
</head>
<body>
	<div align="center" id="content">
		<br /> <br /> <br /> <br /> <br />
		<form id="loginForm" action="loginin.action" method="post">
			<h3>用户登陆</h3>
			<table class="inputView" width="500px">
				<tr>
					<td wdith="100px">用户名:</td>
					<td wdith="200px" align="left"><input type='text' id="username" name='username' size="20" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td align="left"><input type='password' id="password" name='password' size="20" /></td>
				</tr>
				<tr>
					<td colspan='2'><input value="登录" type="submit" /></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>

