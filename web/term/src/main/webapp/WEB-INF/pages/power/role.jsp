<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>角色管理</title>
		<script type="text/javascript" src="${ctx}/js/purview/role.js"></script>
	</head>
	<body>
		<table class="table_query">
			<tr>
				<td align="left">
					<a href="role!input.action">增加角色</a>
				</td>
			</tr>
		</table>
		<table class="table_list" id="roleTable">
			<thead>
				<tr>
					<th>
						系统标识
					</th>
					<th>
						角色名称
					</th>
					<th>
						角色类型
					</th>
					<th>
						父角色
					</th>
					<th>
						说明
					</th>
					<th>
						操作
					</th>
				</tr>
			</thead>
			<s:iterator value="listEntity" status="st">
				<tr <s:if test="#st.even"> class="alt"</s:if>>
					<td>
						${id}
					</td>
					<td>
						${name}
					</td>
					<td>
						${type}
					</td>
					<td>
						${parentId}
					</td>
					<td>
						${memo}
					</td>
					<td align="center">
						<a href="role!input.action?sid=${id}">修改</a>&nbsp;
						<a href="role!delete.action?sid=${id}">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
