<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>


<html>
	<head>
		<title>修改密码</title>
		<script type="text/javascript" src="${ctx}/js/term/power/pwd.js"></script>
	</head>
	<body>
	<div id="content">
		<form action="${ctx}/pwd.action" method="post" id="inputForm">
			<s:actionmessage/>
			<table class="table_form"  width="70%">
				<tr>
					<td class="table_form_td_1">
						旧密码:&nbsp;&nbsp;
					</td>
					<td class="table_form_td_2">
						<input id="password" name="password" type="password" class="text1" />
					</td>
					<td><div id="passwordTip"></div></div></td>
				</tr>
				<tr>
					<td align="right">
						输入新密码:&nbsp;&nbsp;
					</td>
					<td align="left">
						<input id="password21" name="password21" type="password"" class="text1" />
					</td>
					<td><div id="password21Tip"></div></div></td>
				</tr>
				<tr>
					<td align="right">
						确认新密码:&nbsp;&nbsp;
					</td>
					<td align="left">
						<input id="password22" name="password22" type="password" class="text1" />
					</td>
					<td><div id="password22Tip"></div></div></td>
				</tr>
				<tr>
					<td colspan="2" align="center"">
						<input type="submit" value="提交" class="btn-table1"/ >
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置" class="btn-table1"/ >
					</td>
				</tr>
			</table>
		</form>
	</div>
	</body>
</html>