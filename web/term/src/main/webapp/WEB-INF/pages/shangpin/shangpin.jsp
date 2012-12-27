<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>商品管理</title>
		<script type="text/javascript" src="${ctx}/js/purview/role.js"></script>
	</head>
	<body>
		<table class="table_query" class="tableTdMenu">
			<tr>
				<td align="left" class="tableTdMenu">
					<a href="shangpin!input.action">添加商品</a>
				</td>
			</tr>
		</table>
		<table class="table_list" id="roleTable">
			<thead>
				<tr>
					<th>
						名称
					</th>
					<th>
						类型
					</th>
					<th>
						供应商
					</th>
					<th>
						备注
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
						${type}
					</td>
					<td>
						${companyDto.name}
					</td>
					<td>
						${memo}
					</td>
					<td align="center">
						<a href="shangpin!input.action?sid=${id}">修改</a>&nbsp;
						<a href="shangpin!delete.action?sid=${id}">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<c:set var="thisUrl" value="shangpin.action" ></c:set>
		<%@ include file="/WEB-INF/pages/template/page.jsp"%>
	</body>
</html>
