<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>角色管理</title>
		<link type="text/css" rel="stylesheet"
			href="${ctx}/js/jquery/formValidator3.3/style/validator.css"></link>
	</head>
	<body>
		<script src="${ctx}/js/jquery/formValidator3.3/formValidator_min.js"
			type="text/javascript"></script>
		<script src="${ctx}/js/jquery/formValidator3.3/formValidatorRegex.js"
			type="text/javascript"></script>
		<script type="text/javascript" src="${ctx}/js/term/power/role.js"></script>
		<div>
			<b>注意</b>: 角色的系统标识必须以 ' TERM_ ' 开头
		</div>
		<form id="role" action="role!saveOrUpdate.action" method="post">
			<table class="table_form" width="70%">
				<tr>
					<td class="table_form_td_1">
						系统标识
						<font color="#FF0000">*</font>:
					</td>
					<td class="table_form_td_2">
						<input type="text" id="id" name="entity.id" />
					</td>
					<td>
						<div id="idTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						角色名称
						<font color="#FF0000">*</font>:
					</td>
					<td>
						<input type="text" id="name" name="entity.name" />
					</td>
					<td>
						<div id="nameTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						角色类型:
					</td>
					<td>
						<input type="text" id="type" name="entity.type" />
					</td>
					<td>
						<div id="typeTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						父角色:
					</td>
					<td>
						<input type="text" id="parentId" name="entity.roleDto.id" />
					</td>
					<td>
						<div id="parentIdTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						说明:
					</td>
					<td>
						<input type="text" id="memo" name="entity.memo" />
					</td>
					<td>
						<div id="memoTip"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input id="roleSubmit" type="submit" value="提交" />
						&nbsp;
						<input type="button" value="取消" onclick="history.back()" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
