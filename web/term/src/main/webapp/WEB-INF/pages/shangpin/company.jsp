<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>客户与供应商管理</title>
	</head>
	<body>
		<table class="table_query">
			<tr>
				<td align="left" class="tableTdMenu">
					<a href="company!input.action">增加客户或供应商</a>
				</td>
			</tr>
		</table>
		<table class="table_list">
			<thead>
				<tr>
					<th>
						名称
					</th>
					<th>
						联系人
					</th>
					<th>
						电话
					</th>
					<th>
						地址
					</th>
					<th>
						邮箱
					</th>
					<th>
						类型
					</th>
					<th>
						操作
					</th>
				</tr>
			</thead>
			<s:iterator value="listEntity" status="st">
				<tr <s:if test="#st.even"> class="alt"</s:if>>
					<td>
						${name}
					</td>
					<td>
						${linkman}
					</td>
					<td>
						${phone}
					</td>
					<td>
						${address}
					</td>
					<td>
						${email}
					</td>
					<td>
						${type}
					</td>
					<td align="center">
						<a href="company!input.action?sid=${id}">修改</a>&nbsp;
						<a href="company!delete.action?sid=${id}">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<c:set var="thisUrl" value="company.action" ></c:set>
		<%@ include file="/WEB-INF/pages/template/page.jsp"%>
	</body>
</html>
