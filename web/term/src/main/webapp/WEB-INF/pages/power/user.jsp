<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>


<html>
	<head>
		<title>用户管理</title>
		<link rel="stylesheet" type="text/css"	href="${ctx}/css/default.css" />
	</head>
	<body>
		<div id="footer">
			<table class="table_query">
				<tr>
					<td align="left" class="tableTdMenu">
						<a href="user!input.action">增加新用户</a>
					</td>
				</tr>
			</table>
			<table class="table_list" id="userListTable">
				<thead>
					<tr>
						<th>
							用户标识
						</th>
						<th>
							用户名
						</th>
						<th>
							性别
						</th>
						<th>
							手机
						</th>
						<th>
							邮箱
						</th>
						<th>
							住址
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
							${sex}
						</td>
						<td>
							${phone}
						</td>
						<td>
							${email}
						</td>
						<td>
							${address}
						</td>
						<td>
							<a href="user!input.action?sid=${id}">修改</a>&nbsp;
							<a href="user!delete.action?sid=${id}">删除</a>
						</td>
					</tr>
				</s:iterator>
			</table>
			<c:set var="thisUrl" value="user.action" ></c:set>
		<%@ include file="/WEB-INF/pages/template/page.jsp"%>
		</div>
	</body>
</html>